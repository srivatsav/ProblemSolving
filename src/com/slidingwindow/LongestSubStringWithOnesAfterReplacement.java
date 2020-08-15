package com.slidingwindow;

public class LongestSubStringWithOnesAfterReplacement {
  public static void main(String[] args) {
    System.out.println(longestSubstringWithOnes("01100011011", 2));
  }

  private static int longestSubstringWithOnes(String str, int k) {
    int left = 0;
    int maxLen = 0;
    int oneCount = 0;

    for (int right = 0; right < str.length(); right++) {
      char rightChar = str.charAt(right);

      if (rightChar == '1')
        oneCount++;

      if (right - left + 1 - oneCount > k) {
        if (str.charAt(left) == '1')
          oneCount--;
        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }
}