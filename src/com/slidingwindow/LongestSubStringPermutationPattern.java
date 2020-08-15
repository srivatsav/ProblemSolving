package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringPermutationPattern {
  public static void main(String[] args) {

    String str = "aabc";
    String pattern = "abc";

    System.out.println(checkLongestSubStringPermutationPattern(str, pattern));
  }

  private static boolean checkLongestSubStringPermutationPattern(String str, String pattern) {
    int left = 0;
    int matchCount = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (int right = 0; right < str.length(); right++) {
      char rightChar = str.charAt(right);

      if (map.containsKey(rightChar)) {
        map.put(rightChar, map.get(rightChar) - 1);

        if (map.get(rightChar) == 0)
          matchCount++;
      }

      if (right >= pattern.length() - 1) {
        if (matchCount == pattern.length())
          return true;

        char leftChar = str.charAt(left++);

        if (map.containsKey(leftChar)) {
          map.put(leftChar, map.get(leftChar) + 1);
          if (map.get(leftChar) == 0)
            matchCount--;
        }

      }
    }

    return false;
  }
}