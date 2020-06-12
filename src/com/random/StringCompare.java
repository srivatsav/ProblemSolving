package com.random;

public class StringCompare {
  public static void main(String[] args) {
    System.out.println(compare("geeksforgeeks", "forgeksgeeks"));
  }

  public static boolean compare(String str1, String str2) {

    // if two strings are not of equal length they are not identical.
    if (str1.length() != str2.length())
      return false;

    int[] arr = new int[128];

    // updating the letter count in the arr[128]
    for (int i = 0; i < str1.length(); i++)
      arr[(int) str1.charAt(i)]++;

    // for the strings to be identical the letter count should be same.
    // so decrementing the previously updated count.

    for (int i = 0; i < str2.length(); i++) {
      --arr[(int) str2.charAt(i)];
    }

    // After decrementing the letter count if any letter count is > 0 i.e it is a
    // mismatch and they are not identical.
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0)
        return false;
    }

    return true;
  }
}