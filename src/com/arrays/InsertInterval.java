package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
  public static void main(String[] args) {
    int[][] intervlas = { { 1, 3 }, { 6, 9 } };
    int[] interval = { 2, 5 };
    int[][] arr = insertInterval(intervlas, interval);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + "->");
      }
      System.out.println();
    }
  }

  private static int[][] insertInterval(int[][] intervals, int[] interval) {

    int[] left = new int[intervals.length + 1];
    int[] right = new int[intervals.length + 1];

    for (int i = 0; i < intervals.length; i++) {
      left[i] = intervals[i][0];
      right[i] = intervals[i][1];
    }

    left[left.length - 1] = interval[0];
    right[right.length - 1] = interval[1];
    List<int[]> res = new ArrayList<int[]>();

    Arrays.sort(left);
    Arrays.sort(right);

    int start = 0;
    for (int i = 1; i < left.length; i++) {
      if (left[i] > right[i - 1]) {
        res.add(new int[] { left[start], right[i - 1] });
        start = i;
      }
    }

    res.add(new int[] { left[start], right[right.length - 1] });

    return res.toArray(new int[res.size()][2]);
  }
}
