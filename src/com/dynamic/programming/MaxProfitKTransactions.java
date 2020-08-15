package com.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class MaxProfitKTransactions {
  public static void main(String[] args) {

    int[] arr = { 5, 11, 3, 50, 60, 90 };
    System.out.println(maxProfit(arr));
  }

  private static int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;

    if (n == 2 && (prices[1] >= prices[0]))
      return prices[1] - prices[0];
    else if (n == 2 && (prices[1] < prices[0]))
      return 0;

    int[][] dp = new int[3][n];

    for (int i = 0; i < dp.length; i++)
      dp[i][0] = 0;
    for (int i = 0; i < 3; i++)
      dp[0][i] = 0;

    for (int i = 1; i < dp.length; i++) {
      Map<Integer, Integer> map = getPrevMaxProfit(prices, dp, i);
      for (int j = 1; j < dp[i].length; j++) {
        if (j < i)
          dp[i][j] = dp[i - 1][j];
        else {
          dp[i][j] = Math.max(map.get(j), dp[i][j - 1]);
        }
      }
    }

    return dp[2][n - 1];
  }

  private static Map<Integer, Integer> getPrevMaxProfit(int[] prices, int[][] dp, int idx) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int j = 1; j < prices.length; j++) {
      int maxProfit = 0;
      for (int k = 0; k < j; k++) {
        maxProfit = Math.max(maxProfit, prices[j] + dp[idx - 1][k] - prices[k]);
      }
      map.put(j, maxProfit);
    }
    return map;
  }
}