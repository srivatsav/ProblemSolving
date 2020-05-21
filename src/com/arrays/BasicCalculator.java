package com.arrays;

import java.util.Stack;

public class BasicCalculator {
  public static void main(String[] args) {
    //    String str = "3+42*2";
    //    String str = " 3+5 / 2 ";
    //    String str = "1-1+1";
    String str = "0-2147483647";
    System.out.println(evaluateExpression(str));
  }

  private static int evaluateExpression(String str) {

    str = str.replaceAll(" ", "");
    Stack<Integer> stack = new Stack<>();

    int i = 0;
    while (i < str.length()) {
      if (Character.isDigit(str.charAt(i))) {
        String val = "";
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
          val += str.charAt(i);
          i++;
        }
        stack.push(Integer.valueOf(val));
      } else {
        String val = "";
        char op = str.charAt(i);
        while (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))) {
          val += str.charAt(i + 1);
          i++;
        }

        if (op == '-') {

          stack.push(-Integer.valueOf(val));

        } else if (op == '*') {
          stack.push(stack.pop() * Integer.valueOf(val));

        } else if (op == '/') {
          stack.push(stack.pop() / Integer.valueOf(val));

        } else {
          stack.push(Integer.valueOf(val));
        }
        i++;
      }
    }

    int res = 0;

    while (!stack.isEmpty()) {
      res += stack.pop();
    }

    return res;
  }
}
