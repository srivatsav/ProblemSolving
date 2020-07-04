package com.random;

/**
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 */
public class SingleNumber2 {
  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 2, 3, 3, 3 };

    System.out.println(singleNumber(nums));
  }

  private static int singleNumber(int[] nums) {

    int n = nums.length;
    int ans = 0, shift = 1;

    for (int i = 0; i < 32; i++) {
      int count = 0;

      for (int element : nums) {
        if ((element & shift) != 0)
          count++;
      }

      if (count % 3 != 0)
        ans += shift;
      shift *= 2;

    }

    return ans;

  }
}