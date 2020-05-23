package com.arrays;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    // int[] arr = {100, 4, 200, 1, 3, 2};
    int[] arr = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
    int size = arr.length;

    System.out.println(calculateLongestConsecutiveSequence(arr, size));
  }

  static int calculateLongestConsecutiveSequence(int[] arr, int size) {
    Set<Integer> set = new TreeSet<>();
    int longestSequence = 0;

    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    for (Integer integer : set) {
      int sequence = 0;
      int currentNumber = 0;

      if (!set.contains(integer - 1)) {
        sequence = 1;
        currentNumber = integer;
      }
      while (set.contains(currentNumber + 1)) {
        currentNumber++;
        sequence++;
      }

      longestSequence = Math.max(longestSequence, sequence);
    }

    return longestSequence;
  }
}
