package com.dynamic.programming;

/**
 * Longest Repeating Subsequence Given a string, print the longest repeating
 * subsequence such that the two subsequence don’t have same string character at
 * same position, i.e., any i’th character in the two subsequences shouldn’t
 * have the same index in the original string.
 * 
 * 
 * Example: Input: str = "aab" Output: "a" The two subsequence are 'a'(first)
 * and 'a' (second). Note that 'b' cannot be considered as part of subsequence
 * as it would be at same index in both.
 * 
 * Input : AABEBCDD --> Output : ABD
 */
public class LongestRepeatingSubSequence {
  public static void main(String[] args) {

    String str = "AABEBCDD";
    System.out.println(longestRepeatingSubSequence(str));
  }

  private static int longestRepeatingSubSequence(String str) {

    String str1 = str;
    String str2 = str;

    int[][] dp = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 0; i <= str1.length(); i++) {
      for (int j = 0; j <= str2.length(); j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (i != j && str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[str1.length()][str2.length()];
  }
}