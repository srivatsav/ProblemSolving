package com.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallestRight {
  public static void main(String[] args) {
    // int[] arr = { 4, 5, 2, 10, 8 };
    int[] arr = { 2, 1, 5,  6,  3 };

    Stack<Integer> stack = new Stack<Integer>();
    List<Integer> left = new ArrayList<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      if (i == arr.length - 1)
        left.add(-1);
      else if (stack.size() > 0 && stack.peek() < arr[i]) {
        left.add(stack.peek());
      } else if (stack.size() > 0 && stack.peek() > arr[i]) {
        while (stack.size() > 0 && stack.peek() > arr[i])
          stack.pop();

        if (stack.size() == 0)
          left.add(-1);
        else
          left.add(stack.peek());
      }

      stack.push(arr[i]);
    }

    for (Integer num : left)
      System.out.print(num + "--->>");
  }
}