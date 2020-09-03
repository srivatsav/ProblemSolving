package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * 
 * Example:
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 */

public class MaximumAreaHistogram {
  public static void main(String[] args) {

    int[] arr = { 2, 1, 5, 6, 2, 3 };
    // int[] arr = { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 };

    Stack<Pair> stack = new Stack<>();
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();

    int maxArea = 0;

    // NSL
    for (int i = 0; i < arr.length; i++) {
      if (i == 0)
        left.add(-1);
      else if (stack.size() > 0 && stack.peek().val < arr[i]) {
        left.add(stack.peek().idx);
      } else if (stack.size() > 0 && stack.peek().val >= arr[i]) {
        while (stack.size() > 0 && stack.peek().val >= arr[i])
          stack.pop();

        if (stack.size() == 0)
          left.add(-1);
        else
          left.add(stack.peek().idx);
      }
      stack.push(new Pair(i, arr[i]));
    }

    while (!stack.isEmpty())
      stack.pop();

    // NSR
    for (int i = arr.length - 1; i >= 0; i--) {
      if (i == arr.length - 1)
        right.add(arr.length);
      else if (stack.size() > 0 && stack.peek().val < arr[i]) {
        right.add(stack.peek().idx);
      } else if (stack.size() > 0 && stack.peek().val >= arr[i]) {
        while (stack.size() > 0 && stack.peek().val >= arr[i])
          stack.pop();

        if (stack.size() == 0)
          right.add(arr.length);
        else
          right.add(stack.peek().idx);
      }
      stack.push(new Pair(i, arr[i]));
    }

    Collections.reverse(right);

    int[] width = new int[arr.length];

    for (int i = 0; i < right.size(); i++) {
      width[i] = right.get(i) - left.get(i) - 1;
    }

    for (int i = 0; i < arr.length; i++) {
      maxArea = Math.max(maxArea, arr[i] * width[i]);
    }

    System.out.println(maxArea);

  }
}

class Pair {
  int idx;
  int val;

  Pair(int idx, int val) {
    this.idx = idx;
    this.val = val;
  }
}