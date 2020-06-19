package com.random;

import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubSet {
  public static void main(String[] args) {

    int[] nums = { 1, 2, 4, 6, 10, 18 };

    int[] count = new int[nums.length];

    List<Integer> res = new ArrayList<Integer>();

    for (int i = 0; i < count.length; i++)
      count[i] = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          count[i] = Math.max(count[i], count[j] + 1);
        }
      }
    }

    int maxIndex = 0;

    for (int i = 1; i < nums.length; i++)
      maxIndex = count[i] > count[maxIndex] ? i : maxIndex;

    int temp1 = nums[maxIndex];
    int maxLength = count[maxIndex];

    for (int i = maxIndex; i >= 0; i--) {
      if (temp1 % nums[i] == 0 && count[i] == maxLength) {
        res.add(nums[i]);
        maxLength--;
        temp1 = nums[i];
      }
    }

  }
}