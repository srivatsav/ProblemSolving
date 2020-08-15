package com.random;

public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  private static boolean isPalindrome(String s) {

    if (s == null || s.length() == 0)
      return true;

    int left = 0, right = s.length() - 1;

    while (left < right) {
      if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
        left++;
        right--;
      } else if (s.charAt(left) == ' ' || !Character.isLetter(s.charAt(left)))
        left++;
      else if (s.charAt(right) == ' ' || !Character.isLetter(s.charAt(right)))
        right--;
      else
        return false;
    }

    return true;
  }

}
