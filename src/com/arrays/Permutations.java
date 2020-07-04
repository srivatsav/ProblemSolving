package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  static List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };
    permute(arr);
    for (List<Integer> list : res) {
      for (Integer i : list) {
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> permute(int[] nums) {
    helper(new ArrayList<>(), nums);
    return res;
  }

  private static void helper(List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!temp.contains(nums[i])) {
        temp.add(nums[i]);
        helper(temp, nums);
        temp.remove(temp.size() - 1);
      }
    }

  }

}