package com.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public static void main(String[] args) {
    int[] arr = { 1, 0, -1, 0, -2, 2 };
    int target = 0;

    List<List<Integer>> res = calculateQuadraples(arr, target);

    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < res.get(i).size(); j++) {
        System.out.print(res.get(i).get(j) + "->");
      }
      System.out.println();

    }
  }

  private static List<List<Integer>> calculateQuadraples(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    if (nums == null || nums.length < 4)
      return res;

    Arrays.sort(nums);

    int i = 0, j = 0, k = 0, m = 0;
    int sum = 0;

    while (i < nums.length - 3) {
      j = i + 1;

      while (j < nums.length - 2) {
        k = j + 1;
        m = nums.length - 1;

        while (k < m) {
          sum = nums[i] + nums[j] + nums[k] + nums[m];

          if (sum == target) {
            List<Integer> one = new ArrayList<Integer>();
            one.add(nums[i]);
            one.add(nums[j]);
            one.add(nums[k]);
            one.add(nums[m]);

            res.add(one);
            k++;
            while (k < m && nums[k] == nums[k - 1])
              k++;
            m--;
          } else if (sum > target) {
            m--;
          } else {
            k++;
          }
        }

        j++;
        while (j < nums.length - 2 && nums[j] == nums[j - 1])
          j++;
      }

      i++;
      while (i < nums.length - 1 && nums[i] == nums[i - 1])
        i++;
    }
    return res;

  }

}