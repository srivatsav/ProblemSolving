package com.arrays;

import java.util.Stack;

public class RemoveKElements {

  public static void main(String[] args) {

    String str = "1432279";
    // String str = "10200";
    // String str = "100";
    // String str = "1234567890";
    int k = 3;

    System.out.println(removeKElements(str, k));
  }

  static String removeKElements(String str, int k) {

    if (k == 0)
      return str;

    if (str.length() == k)
      return "0";

    Stack<Character> stack = new Stack<Character>();

    stack.push(str.charAt(0));

    for (int i = 1; i < str.length(); i++) {
      if (!stack.isEmpty() && stack.peek() > str.charAt(i) && k != 0) {
        while (!stack.isEmpty() && stack.peek() > str.charAt(i) && k != 0) {
          stack.pop();
          k--;
        }
        stack.push(str.charAt(i));
      } else {
        stack.push(str.charAt(i));
      }
    }

    StringBuffer sb = new StringBuffer();

    while (!stack.isEmpty()) {
      if (k > 0) {
        k--;
        stack.pop();
      } else
        sb.append(stack.pop());
    }

    String res = sb.reverse().toString();
    int index = 0;

    for (int i = 0; i < res.length(); i++) {
      if (res.charAt(i) == '0') {
        index++;
      } else
        break;

    }

    if (index >= res.length())
      return "0";

    return res.substring(index, res.length());

  }

}