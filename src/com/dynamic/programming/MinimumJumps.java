package com.dynamic.programming;

/**
 * Minimum number of jumps Given an array of integers where each element
 * represents the max number of steps that can be made forward from that
 * element. The task is to find the minimum number of jumps to reach the end of
 * the array (starting from the first element). If an element is 0, then cannot
 * move through that element.
 * 
 * Input: The first line contains an integer T, depicting total number of test
 * cases. Then following T lines contains a number n denoting the size of the
 * array. Next line contains the sequence of integers a1, a2, ..., an.
 * 
 * Output: For each testcase, in a new line, print the minimum number of jumps.
 * If answer is not possible print "-1"(without quotes).
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ N ≤ 107 0 <= ai <= 107
 * 
 * Example: Input: 2 11 1 3 5 8 9 2 6 7 6 8 9 6 1 4 3 2 6 7 Output: 3 2
 * 
 * Explanation: Testcase 1: First jump from 1st element, and we jump to 2nd
 * element with value 3. Now, from here we jump to 5h element with value 9. and
 * from here we will jump to last.
 */

public class MinimumJumps {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
    int[] arr1 = { 1, 4, 3, 2, 6, 7 };
    int[] arr2 = { 1, 0, 0 };
    int[] arr3 = { 1, 1, 0 };
    int[] arr4 = { 1, 2, 0, 0, 0 };
    // System.out.println(minimumJumps(arr1, arr1.length));
    System.out.println(minJumps(arr, arr.length));
  }

  // function to find minimum number of jumps to reach end of the array
  public static int minimumJumps(int arr[], int n) {
    // your code here
    if (n <= 1)
      return 0;
    if (arr[0] == 0)
      return -1;

    int step = arr[0];
    int max = arr[0];
    int jump = 1;

    for (int i = 1; i < n; i++) {
      if (i == n - 1)
        return jump;
      max = Math.max(i + arr[i], max);
      step--;

      if (step == 0) {
        ++jump;
        if (i >= max)
          return -1;
        step = max - i;
      }
    }
    return jump;
  }

  /**
   * { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }
   * 
   * { 1, 4, 3, 2, 6, 7 }
   * 
   * @param arr
   * @param n
   * @return
   */
  public static int minJumps(int[] nums, int n) {
    if (nums.length == 1)
      return 0;
    int position = nums[0];
    int maxPosition = nums[0];
    int jumps = 1;
    for (int i = 1; i < nums.length; i++) {
      if (position < i) {
        jumps++;
        position = maxPosition;
      }
      maxPosition = Math.max(i + nums[i], maxPosition);
    }
    return jumps;

  }
}