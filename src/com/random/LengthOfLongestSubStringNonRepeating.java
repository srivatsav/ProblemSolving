package com.random;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubStringNonRepeating {
  public static void main(String[] args) {
    System.out.print(lengthOfLongestSubstring("ccaabbb"));
  }

  public static int lengthOfLongestSubstring(String s) {

    if (s == null)
      return 0;

    if (s.length() <= 1)
      return s.length();

    int maxLen = 0;

    Set<Character> set = new HashSet<Character>();
    int left = 0, right = 0;

    while (right < s.length()) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        maxLen = Math.max(maxLen, set.size());
        right++;
      } else {
        set.remove(s.charAt(left++));
      }
    }

    return maxLen;

  }

}