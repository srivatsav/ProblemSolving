package com.dynamic.programming.knapsack;

/**
 * Rod Cutting Problem Given a rod of length n inches and an array of prices
 * that contains prices of all pieces of size smaller than n. Determine the
 * maximum value obtainable by cutting up the rod and selling the pieces.
 * Example: if length of the rod is 8 and the values of different pieces are
 * given as following, then the maximum obtainable value is 22 (by cutting in
 * two pieces of lengths 2 and 6)
 * 
 * 
 * length | 1 2 3 4 5 6 7 8 ---- price | 1 5 8 9 10 17 17 20
 * 
 */
public class RodCuttingProblem {
  public static void main(String[] args) {
    int[] cost = { 1, 5, 8, 9, 10, 17, 17, 20 };
    int n = 8;
    int[] length = new int[n];

    for (int i = 0; i < n; i++)
      length[i] = i + 1;

    System.out.println(maxProfit(length, cost, n));
  }

  private static int maxProfit(int[] weight, int[] cost, int maxWeight) {

    int n = weight.length;
    int[][] dp = new int[n + 1][maxWeight + 1];

    for (int i = 0; i <= n; i++)
      dp[i][0] = 0;

    for (int i = 1; i <= maxWeight; i++)
      dp[0][1] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= maxWeight; j++) {
        if (weight[i - 1] <= j)
          dp[i][j] = Math.max(dp[i - 1][j], cost[i - 1] + dp[i][j - weight[i - 1]]);
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[n][maxWeight];

  }

}