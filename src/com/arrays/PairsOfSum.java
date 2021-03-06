package com.arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsOfSum {

  public static void main(String[] args) {

    int[] arr = { 1,5,-1,7,5 };
    int target = 6;

    findIndexOfPairsForTarget(arr, target);
  }

  static void findIndexOfPairsForTarget(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < arr.length; i++) {

      if (map.containsKey(arr[i])) {
        System.out.println("Pair found at :: " + map.get(arr[i]) + " and " + i);
      } else {
        map.put(target - arr[i], i);
      }

    }
  }
}