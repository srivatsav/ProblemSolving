package com.random;

public class Division {

  public static void main(String[] args) {
    System.out.println(divide(7, -3));
  }

  public static int divide(long dividend, long divisor) {

    if (dividend == 0)
      return 0;

    int sign = 1;

    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
      sign = -1;

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    if (dividend < divisor)
      return 0;

    long res = 1;
    long originalDivisor = divisor;

    if (divisor == 1)
      res = dividend;
    else if (divisor == dividend)
      res = 1;
    else
      while (divisor + divisor <= dividend) {
        res++;
        divisor += divisor;
      }
    res += divide(dividend - divisor, originalDivisor);

    return sign * (int) res;

  }
}
