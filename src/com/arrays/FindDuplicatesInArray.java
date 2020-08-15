package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {
  public static void main(String[] args) {
    int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
    findDuplicates(arr, arr.length);
  }

  private static List<Integer> findDuplicates(int[] arr, int n) {
    List<Integer> res = new ArrayList<>(n);

    for (int i = 0; i <= n; i++)
      res.add(0);

    for (int i = 0; i < n; i++) {
      if (res.get(arr[i]) == 0) {
        res.add(arr[i], 1);
      } else {
        int temp = res.get(arr[i]);
        res.add(arr[i], temp + 1);
      }
    }
    return res;
  }
}