package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more
 * than K distinct characters.
 */
public class LongestSubStringKDistinct {
  public static void main(String[] args) {
    System.out.println(longestSubStringKDistinct("cbbebi", 3));
  }

  private static int longestSubStringKDistinct(String string, int k) {

    int left = 0, maxLength = Integer.MIN_VALUE;

    Map<Character, Integer> map = new HashMap<>();

    for (int right = 0; right < string.length(); right++) {
      char c = string.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);

      while (map.size() > k) {
        char leftChar = string.charAt(left);
        map.put(leftChar, map.get(leftChar) - 1);

        if (map.get(leftChar) == 0)
          map.remove(leftChar);
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
  }
}