package com.dynamic.programming;

public class MinimumJumps {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
    int[] arr1 = { 1, 4, 3, 2, 6, 7 };
    int[] arr2 = { 1, 0, 0 };
    int[] arr3 = { 1, 1, 0 };
    int[] arr4 = { 1, 2, 0, 0, 0 };
    System.out.println(minimumJumps(arr1, arr1.length));
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
}