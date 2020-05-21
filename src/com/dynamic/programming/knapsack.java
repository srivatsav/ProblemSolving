package com.dynamic.programming;

public class knapsack {
  public static void main(String[] args) {

    int[] v = {10, 40, 30, 50};
    int[] w = {5, 4, 6, 3};
    int maxWeight = 10;

    // int optimalWeight = recursiveKnapSack(maxWeight, v, w, v.length);
    // System.out.println("Optimal Weight :: " + optimalWeight);

    int optimalWeightDP = dpKnapSack(maxWeight, v, w, v.length);
    System.out.println("Optimal Weight :: " + optimalWeightDP);
  }

  static int recursiveKnapSack(int maxWeight, int[] v, int[] w, int n) {

    if (n == 0 || maxWeight == 0) return 0;

    if (w[n - 1] > maxWeight) {
      return recursiveKnapSack(maxWeight, v, w, n - 1);
    } else {
      return Math.max(
          recursiveKnapSack(maxWeight, v, w, n - 1),
          v[n - 1] + recursiveKnapSack(maxWeight - w[n - 1], v, w, n - 1));
    }
  }

  static int dpKnapSack(int W, int[] v, int[] w, int n) {

    int[][] dpArray = new int[n + 1][W + 1];

    /**
     * columns -> weights from 0 to W (knapsack capacity) rows -> the weight that can be choosen.
     */
    for (int i = 0; i <= W; i++) dpArray[0][i] = 0;
    for (int i = 0; i <= n; i++) dpArray[i][0] = 0;

    /**
     * 1. If, the knapsack capacity is less than the current weight it will have the same weight of
     * elements without current weight.
     *
     * <p>2. Else, max of (the value of weight chosen + value of weight until now , excluding the
     * current weight)
     */
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= W; j++) {
        if (w[i - 1] > j) {
          dpArray[i][j] = dpArray[i - 1][j];
        } else {
          dpArray[i][j] = Math.max(v[i - 1] + dpArray[i - 1][j - w[i - 1]], dpArray[i][j - 1]);
        }
      }
    }

    return dpArray[n][W];
  }
}
