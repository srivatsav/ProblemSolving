package com.dynamic.programming;

/**
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 *
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix.
 * 
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * 
 * Find the minimum cost to paint all houses.
 * 
 */
public class PaintHouse2 {

  public static void main(String[] args) {
    int[][] cost = { { 14, 2, 11 }, { 11, 14, 5 }, { 14, 3, 10 } };
    // calculateMinPaintingCost(cost);
    System.out.println(calculateOptimalMinPaintingCost(cost));
  }

  /**
   * O (n*k*k) complexity
   */
  public static int calculateMinPaintingCost(int[][] cost) {
    if (cost == null || cost.length == 0)
      return 0;

    int n = cost.length;
    int k = cost[0].length;

    int[][] dp = new int[n][k];

    for (int i = 0; i < k; i++)
      dp[0][i] = cost[0][i];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < k; j++) {
        dp[i][j] = Integer.MAX_VALUE;

        for (int m = 0; m < k; m++) {
          if (m != j)
            dp[i][j] = Math.min(dp[i - 1][m] + cost[i][j], dp[i][j]);
        }
      }
    }

    int minCost = Integer.MAX_VALUE;

    for (int i = 0; i < k; i++)
      minCost = Math.min(dp[n - 1][i], minCost);

    return minCost;

  }

  /**
   * O (n*k)
   */
  public static int calculateOptimalMinPaintingCost(int[][] cost) {
    if (cost == null || cost[0].length == 0)
      return 0;

    int n = cost.length;
    int k = cost[0].length;

    int[] dp = new int[k];
    int min1 = 0;
    int min2 = 0;

    for (int i = 0; i < n; i++) {
      int oldMin1 = min1;
      int oldMin2 = min2;

      min1 = Integer.MAX_VALUE;
      min2 = Integer.MAX_VALUE;

      for (int j = 0; j < k; j++) {
        if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
          dp[j] = oldMin1 + cost[i][j];
        } else {
          dp[j] = oldMin2 + cost[i][j];
        }

        if (min1 <= dp[j]) {
          min2 = Math.min(dp[j], min2);
        } else {
          min2 = min1;
          min1 = dp[j];
        }

      }
    }

    return min1;
  }
}