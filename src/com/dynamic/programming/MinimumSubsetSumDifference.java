package com.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum of subset differences Given a set of integers, the task is to divide it
 * into two sets S1 and S2 such that the absolute difference between their sums
 * is minimum. If there is a set S with n elements, then if we assume Subset1
 * has m elements, Subset2 must have n-m elements and the value of
 * abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * 
 * Example: Input: arr[] = {1, 6, 11, 5} Output: 1 Explanation: Subset1 = {1, 5,
 * 6}, sum of Subset1 = 12 Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSubsetSumDifference {
  public static void main(String[] args) {
    int[] arr = { 1, 6, 11, 5 };
    System.out.println(minSubsetSumDifference(arr));
  }

  private static int minSubsetSumDifference(int[] arr) {
    int range = 0;

    for (int i = 0; i < arr.length; i++)
      range += arr[i];

    int n = arr.length;

    boolean[][] dp = new boolean[n + 1][range + 1];

    findSubSetSum(dp, arr, range);

    List<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i <= range / 2; i++) {
      if (dp[n][i])
        list.add(i);
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < list.size(); i++)
      min = Math.min(min, range - (2 * list.get(i)));

    return min;
  }

  private static void findSubSetSum(boolean[][] dp, int[] nums, int range) {
    for (int i = 0; i < dp.length; i++)
      dp[i][0] = true;

    for (int i = 1; i < dp[0].length; i++)
      dp[0][i] = false;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (nums[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
  }
}