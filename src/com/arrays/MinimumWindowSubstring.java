package com.arrays;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(calculateMinWindowSubString("BDAB", "AB"));
  }

  public static String calculateMinWindowSubString(String s, String t) {
    if (s.length() == 0 || t.length() > s.length()) return "";

    String res = null;

    int[] arr1 = new int[128];
    int[] arr2 = new int[128];

    for (int i = 0; i < t.length(); i++) arr1[t.charAt(i)]++;

    int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      arr2[s.charAt(i)]++;

      if (arr1[s.charAt(i)] != 0 && arr1[s.charAt(i)] <= arr2[s.charAt(i)]) {
        count++;
      }

      if (count == t.length()) {
        while (arr2[s.charAt(start)] > arr1[s.charAt(start)] || arr2[s.charAt(start)] == 0) {
          if (arr2[s.charAt(start)] > arr1[s.charAt(start)]) arr2[s.charAt(start)]--;
          start++;
        }

        int len_window = i - start + 1;
        if (min_len > len_window) {
          min_len = len_window;
          start_index = start;
        }
      }
    }

    if (start_index == -1) {
      return "";
    }
    return s.substring(start_index, start_index + min_len);
  }
}
