package com.dynamic.programming;

public class LongestPalindromeSubString {

  static int maxLen = 1;
  static int startIndex = 0;
  static int endIndex = 0;

  public static void main(String[] args) {

    System.out.println(longestPalindrome("aaabaaaa"));
  }

  private static String longestPalindrome(String s) {

    if (s == null || s.length() == 0)
      return "";

    if (s.length() <= 1)
      return s;

    int n = s.length();

    // odd palindromie
    for (int i = 0; i < n - 1; i++) {
      int l = i, r = i;
      getPalindromeLength(s, l, r, n);
    }

    // even palindrome
    for (int i = 0; i < n - 1; i++) {
      int l = i, r = i + 1;
      getPalindromeLength(s, l, r, n);
    }

    return s.substring(startIndex, endIndex + 1);
  }

  private static void getPalindromeLength(String s, int l, int r, int n) {
    while (l >= 0 && r < n) {
      if (s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
      } else
        break;
    }
    int len = r - l - 1;
    if (len > maxLen) {
      maxLen = len;
      startIndex = l + 1;
      endIndex = r - 1;
    }
  }
}