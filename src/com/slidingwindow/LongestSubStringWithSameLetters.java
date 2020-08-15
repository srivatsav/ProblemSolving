package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no
 * more than ‘k’ letters with any letter, find the length of the longest
 * substring having the same letters after replacement.
 * 
 * Example 1:
 * 
 * Input: String="aabccbb", k=2 Output: 5 Explanation: Replace the two 'c' with
 * 'b' to have a longest repeating substring "bbbbb". Example 2:
 * 
 * Input: String="abbcb", k=1 Output: 4 Explanation: Replace the 'c' with 'b' to
 * have a longest repeating substring "bbbb". Example 3:
 * 
 * Input: String="abccde", k=1 Output: 3 Explanation: Replace the 'b' or 'd'
 * with 'c' to have the longest repeating substExample 1:
 * 
 * Input: String="aabccbb", k=2 Output: 5 Explanation: Replace the two 'c' with
 * 'b' to have a longest repeating substring "bbbbb". Example 2:
 * 
 * Input: String="abbcb", k=1 Output: 4 Explanation: Replace the 'c' with 'b' to
 * have a longest repeating substring "bbbb". Example 3:
 * 
 * Input: String="abccde", k=1 Output: 3 Explanation: Replace the 'b' or 'd'
 * with 'c' to have the longest repeating substring "ccc".ring "ccc".
 */

public class LongestSubStringWithSameLetters {
  public static void main(String[] args) {
    System.out.println(longestSubStringWithSameLetters("abbcb", 1));
  }

  private static int longestSubStringWithSameLetters(String str, int k) {

    int maxLen = 0;
    int maxOccurences = 0;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int right = 0; right < str.length(); right++) {
      char rightChar = str.charAt(right);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      maxOccurences = Math.max(maxOccurences, map.get(rightChar));

      if (right - left + 1 - maxOccurences > k) {
        char leftChar = str.charAt(left++);
        map.put(leftChar, map.get(leftChar) - 1);
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;

  }

}