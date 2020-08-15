package com.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
  public static void main(String[] args) {
    System.out.println(climbStairs(10));
  }

  private static int climbStairs(int n) {
    return computeSteps(n, new HashMap<Integer, Integer>());
  }

  private static int computeSteps(int n, Map<Integer, Integer> map) {
    if (n < 0)
      return 0;

    if (n == 0)
      return 1;

    if (map.containsKey(n))
      return map.get(n);

    int count = 0;
    count += computeSteps(n - 1, map) + computeSteps(n - 2, map);

    map.put(n, count);
    return count;
  }
}