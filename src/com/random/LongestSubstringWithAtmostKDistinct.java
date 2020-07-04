package com.random;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinct {
  public static void main(String[] args) {
    System.out.println(longestSubstringWithAtmostKDistinct("ccaabbbb", 2));
  }

  private static int longestSubstringWithAtmostKDistinct(String str, int k) {
    if (str.length() < 3)
      return str.length();

    Map<Character, Integer> map = new HashMap<Character, Integer>();

    int maxLen = 0;
    int left = 0;
    int count = 0;
    String res = "";

    for (int right = 0; right < str.length(); right++) {

      char c = str.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);

      count++;

      while (count > k) {
        map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
        if (map.get(str.charAt(left)) == 0) {
          map.remove(str.charAt(left));
        }
        count--;
        left++;
      }

      maxLen = Math.max(maxLen, count);
    }
    return maxLen;
  }
}
