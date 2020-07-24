package com.arrays;

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

    if (nums == null)
      return nums;

    int k = 0;
    for (int num : nums)
      k ^= num;

    int mask = k & -k;

    int x = 0;
    int y = 0;
    for (int num : nums) {
      if ((num & mask) == 0)
        x ^= num;
      else
        y ^= num;
    }

    return new int[] { x, y };
  }

}