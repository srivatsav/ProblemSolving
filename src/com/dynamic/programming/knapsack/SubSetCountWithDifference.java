package com.dynamic.programming.knapsack;

public class SubSetCountWithDifference {
  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 3 };
    int diff = 1;
    System.out.println(subSetCountWithDiff(arr, diff));
  }

  private static int subSetCountWithDiff(int[] arr, int diff) {

    int n = arr.length;

    int totalSum = 0;
    for (int i = 0; i < n; i++)
      totalSum += arr[i];

    int subSetSum = (totalSum + diff) / 2;

    int[][] dp = new int[n + 1][subSetSum + 1];

    for (int i = 0; i < dp.length; i++)
      dp[i][0] = 1;

    for (int i = 1; i < dp[0].length; i++)
      dp[0][i] = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][subSetSum];
  }

}