package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * 
 * Example
 * 
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueHeight {
  public static void main(String[] args) {
    int[][] arr = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
    int[][] res = reconstructQueue(arr);

    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i][0] + "-->" + res[i][1]);
    }
  }

  public static int[][] reconstructQueue(int[][] arr) {

    List<int[]> res = new ArrayList<int[]>();
    Arrays.sort(arr, new Comparator<int[]>() {

      @Override
      public int compare(int[] arg0, int[] arg1) {
        return arg0[0] == arg1[0] ? arg0[1] - arg1[1] : arg1[0] - arg0[0];
      }
    });

    for (int[] a : arr) {
      res.add(a[1], a);
    }

    return res.toArray(new int[res.size()][]);
  }
}