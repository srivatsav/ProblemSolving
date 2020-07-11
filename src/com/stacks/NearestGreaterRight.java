package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterRight {

  public static void main(String[] args) {

    int[] arr = { 2, 1, 5, 6, 3 };

    Stack<Integer> stack = new Stack<Integer>();
    List<Integer> res = new ArrayList<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      if (i == arr.length - 1)
        res.add(-1);
      else if (stack.size() > 0 && stack.peek() > arr[i]) {
        res.add(stack.peek());
      } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
        while (stack.size() > 0 && stack.peek() <= arr[i])
          stack.pop();

        if (stack.isEmpty())
          res.add(-1);
        else
          res.add(stack.peek());
      }
      stack.push(arr[i]);
    }

    Collections.reverse(res);

    for (int j : res) {
      System.out.print(j + "-->");
    }

  }

}