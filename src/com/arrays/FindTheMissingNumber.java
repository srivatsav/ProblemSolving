package com.arrays;

/**
 * We are given an array containing ‘n’ distinct numbers taken from the range 0
 * to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
 * find the missing number.
 * 
 * Input: [4, 0, 3, 1] Output: 2
 * 
 */
public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] arr = { 8, 3, 5, 2, 4, 6, 0, 1 };
        findMissingNumber(arr, arr.length);
    }

    private static void findMissingNumber(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] < n && arr[i] != arr[arr[i]]) {
                swap(arr, i, arr[i]);
            } else
                i++;
        }

        for (i = 0; i < n; i++) {
            if (arr[i] != i) {
                System.out.println("The Missing Number is :: " + i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
