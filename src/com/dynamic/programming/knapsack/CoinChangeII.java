package com.dynamic.programming.knapsack;

public class CoinChangeII {
  public static void main(String[] args) {
    int[] coins = { 1, 2, 5 };
    int amount = 11;

    coinChange(coins, amount);
  }

  private static int coinChange(int[] coins, int amount) {

    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];
    int minCount = Integer.MAX_VALUE;

    for (int i = 0; i <= n; i++)
      dp[i][0] = 1;

    for (int i = 1; i <= amount; i++)
      dp[0][i] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= amount; j++) {
        if (coins[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];

        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return minCount;
  }
}