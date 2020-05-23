package com.arrays;

public class NonAdjacentMaxSum {

  public static void main(String[] args) {
    int[] arr = { 4, 2, 1, 12 };
    System.out.println(computeNonAdjacentMaxSum(arr, arr.length));
  }

  static int computeNonAdjacentMaxSum(int[] arr, int n) {
    int inclusion = arr[0];
    int exclusion = 0;
    int temp;

    for (int i = 1; i < n; i++) {
      temp = Math.max(inclusion, exclusion);
      inclusion = exclusion + arr[i];
      exclusion = temp;
    }

    return Math.max(inclusion, exclusion);
  }
}