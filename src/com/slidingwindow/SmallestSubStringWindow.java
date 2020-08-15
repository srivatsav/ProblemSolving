package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubStringWindow {
  public static void main(String[] args) {
    String str = "aabdec";
    String pattern = "abc";

    System.out.println(smallestSubStringWindow(str, pattern));
  }

  private static String smallestSubStringWindow(String str, String pattern) {
    if (str == null || str.length() == 0 || pattern.length() > str.length())
      return "";

    int left = 0;
    int minLen = str.length();
    int matchCount = 0;
    int startIndex = 0;

    Map<Character, Integer> frequencyMap = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      frequencyMap.put(pattern.charAt(i), frequencyMap.getOrDefault(pattern.charAt(i), 0) + 1);
    }

    for (int right = 0; right < str.length(); right++) {

      char rightChar = str.charAt(right);

      if (frequencyMap.containsKey(rightChar)) {
        frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);

        if (frequencyMap.get(rightChar) >= 0)
          matchCount++;
      }

      while (matchCount == pattern.length()) {
        char leftChar = str.charAt(left);

        if (minLen > right - left + 1) {
          minLen = right - left + 1;
          startIndex = left;
        }
        left++;
        if (frequencyMap.containsKey(leftChar)) {
          if (frequencyMap.get(leftChar) == 0)
            matchCount--;
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
        }
      }
    }

    return str.substring(startIndex, startIndex + minLen);
  }
}