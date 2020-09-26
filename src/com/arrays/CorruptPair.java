package com.arrays;

/**
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1
 * to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due
 * to a data error, one of the numbers got duplicated which also resulted in one
 * number going missing. Find both these numbers.
 * 
 * Input: [3, 1, 2, 5, 2] Output: [2, 4] Explanation: '2' is duplicated and '4'
 * is missing.
 */

public class CorruptPair {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 5, 2 };
        findCorruptPair(nums, nums.length);
    }

    private static void findCorruptPair(int[] nums, int n) {
        int i = 0;

        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                System.out.println("The corrupt Pair is " + (i + 1) + "--" + nums[i]);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
