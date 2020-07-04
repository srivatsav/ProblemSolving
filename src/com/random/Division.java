package com.random;

public class Division {

  public static void main(String[] args) {
    divide(-2147483648, -1);
  }

  public static int divide(int dividend, int divisor) {

    int count = 0;
    int temp = Math.abs(dividend); // 1

    while (temp >= Math.abs(divisor)) {
      temp = temp - Math.abs(divisor);
      count++;
    }

    System.out.println(count);

    return ((divisor > 0 && dividend > 0) || (divisor < 0 && dividend < 0)) ? count : -count;
  }
}
