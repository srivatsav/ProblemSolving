package com.random;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is
 * a subset of the given set with sum equal to given sum. Example:
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True There is a subset
 * (4, 5) with sum 9.
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30 Output: False There is no
 * subset that add up to 30.
 */
public class SubsetSum {
  public static void main(String[] args) {
    int[] arr = { 3, 34, 4, 12, 5, 2 };
    int sum = 9;
    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= sum; i++) {
      dp[0][i] = false;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {

        if (arr[i - 1] > j)
          dp[i][j] = dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];

      }
    }

    System.out.println(dp[n][sum]);

  }
}
