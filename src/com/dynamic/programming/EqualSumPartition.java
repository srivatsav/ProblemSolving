package com.dynamic.programming;

public class EqualSumPartition {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 6 };
    int sum = 6;
    System.out.println(partitionSum(arr, sum));
  }

  private static boolean partitionSum(int[] arr, int sum) {

    int arrSum = 0;
    for (int i = 0; i < arr.length; i++)
      arrSum += arr[i];

    if (arrSum % 2 != 0)
      return false;

    return findSumSubset(arr, sum / 2);
  }

  private static boolean findSumSubset(int[] arr, int sum) {
    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= sum; i++)
      dp[0][i] = false;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j)
          dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[n][sum];
  }
}