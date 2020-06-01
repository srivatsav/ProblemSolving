package com.random;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of distinct elements. The task is to find triplets in the
 * array whose sum is zero.
 * 
 * Input : arr[] = {0, -1, 2, -3, 1} Output : (0 -1 1), (2 -3 1)
 * 
 * Explanation : The triplets with zero sum are 0 + -1 + 1 = 0 and 2 + -3 + 1 =
 * 0
 * 
 */

public class FindTripletsOfZeroSum {
  public static void main(String[] args) {
    int[] arr = { -1, 0, 1, 1, 2, -1, -4 };
    System.out.println(findTripletsOfZeroSum(arr, arr.length));
  }

  static int findTripletsOfZeroSum(int[] arr, int n) {

    int noOfTriplets = 0;

    for (int i = 0; i < n - 1; i++) {
      HashSet<Integer> set = new HashSet<Integer>();

      for (int j = i + 1; j < n; j++) {
        int x = -(arr[i] + arr[j]);
        if (set.contains(x)) {
          noOfTriplets++;
        } else {
          set.add(arr[j]);
        }
      }
    }

    return noOfTriplets;
  }

}