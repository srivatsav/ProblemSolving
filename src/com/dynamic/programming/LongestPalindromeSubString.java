package com.dynamic.programming;

public class LongestPalindromeSubString {
  public static void main(String[] args) {

    System.out.println(longestPalindrome("aaabaaaa"));
  }

  private static String longestPalindrome(String s) {

    if (s == null || s.length() == 0)
      return "";

    int left = 0, right = s.length() - 1;
    int lIndex = 0;
    int rIndex = 0;

    while (left <= right) {
      int temp1 = left;
      int count = 0;
      int i;

      for (i = right; i >= temp1; i--) {

        if (temp1 == i) {
          break;
        }

        if (s.charAt(temp1) != s.charAt(i)) {
          count = 0;
          continue;
        }
        count += 2;
        temp1++;
      }

      if (i < temp1 && rIndex - lIndex < count) {
        lIndex = left;
        rIndex = left + count;
      } else if (i == temp1 && rIndex - lIndex < count + 1) {
        lIndex = left;
        rIndex = left + count + 1;

      }

      left++;
    }

    return s.substring(lIndex, rIndex);
  }
}