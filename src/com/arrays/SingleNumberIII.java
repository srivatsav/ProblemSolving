package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * Example:
 * 
 * Input: [1,2,1,3,2,5] Output: [3,5] Note:
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct. Your algorithm should run in linear runtime complexity. Could
 * you implement it using only constant space complexity?
 */
public class SingleNumberIII {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 1, 3, 2, 5 };
    int[] res = singleNumber(arr);
    for (int i = 0; i < res.length; i++)
      System.out.println(res[i]);
  }

  private static int[] singleNumber(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) == null) {
        map.put(nums[i], 1);
      } else {
        map.remove(nums[i]);
      }
    }

    int[] res = new int[map.size()];
    int k = 0;

    for (Map.Entry<Integer, Integer> entry : map.entrySet())
      res[k++] = entry.getKey();

    return res;
  }

}