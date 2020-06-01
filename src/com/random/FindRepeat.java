package com.random;

import java.util.HashMap;

/**
 * Given two positive integers A and B denoting numerator and denomenator of a
 * fraction . You need to count the length of repeated pattern of digits in
 * decimal part of A/B .
 * 
 * 22/7 = 3.142857142857142857.... length of repeating pattern in decimal part
 * is 6
 */

public class FindRepeat {

  public static void main(String[] args) {
    System.out.println(findRepeat(22, 7));
  }

  static int findRepeat(int p, int q) {

    if (p % q == 0)
      return 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    Integer init_rem = p % q;
    Integer current_dividend = p % q;
    int i, new_rem = -1;

    map.put(init_rem, 0);

    int k = 0;

    while (true) {
      i = 0;
      while (current_dividend < q) {
        if (i == 0) {
          current_dividend *= 10;
        } else {
          current_dividend *= 10;
          k++;
        }
        i++;
      }
      new_rem = current_dividend % q;
      k++;

      if (!map.containsKey(new_rem)) {
        map.put(new_rem, k);
      } else {
        return k - map.get(new_rem);
      }

      current_dividend = new_rem;

      if (new_rem == 0)
        return 0;

    }
  }
}