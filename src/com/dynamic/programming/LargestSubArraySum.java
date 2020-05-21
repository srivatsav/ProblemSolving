package com.dynamic.programming;

public class LargestSubArraySum {

  public static void main(String[] args) {
    int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(findMaxSumSubArray(arr, arr.length));
  }

  static int findMaxSumSubArray(int[] arr, int n) {
    int sum = 0, ans = 0;
    for (int i = 0; i < n; i++) {
      if (sum + arr[i] > 0) {
        sum += arr[i];
      } else {
        sum = 0;
      }
      ans = Math.max(sum, ans);
    }
    return ans;
  }
}
