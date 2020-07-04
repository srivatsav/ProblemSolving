package com.arrays;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(calculateMinWindowSubString("ADOBECODEBANC", "ABC"));
  }

  public static String calculateMinWindowSubString(String s, String t) {
    if (s.length() == 0 || t.length() > s.length())
      return "";

    String res = null;

    int[] arr = new int[128];

    for (char c : t.toCharArray()) {
      arr[c]++;
    }

    int left = 0, count = 0, minLength = Integer.MAX_VALUE;

    for (int right = 0; right < s.length(); right++) {
      if (--arr[s.charAt(right)] >= 0) {
        count++;
      }

      while (count == t.length()) {
        if (right - left + 1 < minLength) {
          minLength = right - left + 1;
          res = s.substring(left, right + 1);
        }

        if (++arr[s.charAt(left)] > 0)
          count--;
        left++;
      }

    }

    return res;

  }
}
