package com.arrays;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of
 * s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 * <p>Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2 contains one permutation of s1
 * ("ba").
 *
 * <p>Input:s1= "ab" s2 = "eidboaoo" Output: False
 */
public class PermutationInString {
  public static void main(String[] args) {
    checkIfPermutationInString("ab", "eidoooba");
  }

  public static boolean checkIfPermutationInString(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    int[] arr1 = new int[26];
    int[] arr2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      arr1[s1.charAt(i) - 'a']++;
      arr2[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (matches(arr1, arr2)) return true;
      arr2[s2.charAt(i + s1.length()) - 'a']++;
      arr2[s2.charAt(i) - 'a']--;
    }

    return matches(arr1, arr2);
  }

  public static boolean matches(int[] arr1, int[] arr2) {
    for (int i = 0; i < 26; i++) {
      if (arr1[i] != arr2[i]) return false;
    }
    return true;
  }
}
