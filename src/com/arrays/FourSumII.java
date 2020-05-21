package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
  public static void main(String[] args) {
    int[] A = {-1, -1};
    int[] B = {-1, 1};
    int[] C = {-1, 1};
    int[] D = {1, -1};
    System.out.print(fourSumCount(A, B, C, D));
  }

  public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

    int sumCount = 0;

    int n = A.length;

    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int res = A[i] + B[j];
        if (map1.containsKey(res)) {
          map1.put(res, map1.get(res) + 1);
        } else {
          map1.put(res, 1);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int res = C[i] + D[j];
        if (map1.containsKey(res)) {
          int count = map1.get(res);
          map1.put(res, count + 1);
        }
        else if (map1.containsKey(-res)) {
          int count = map1.get(-res);
          map1.put(-res, count - 1);
        }
      }
    }

    for(Map.Entry<Integer,Integer> entry: map1.entrySet())
    {
      sumCount+=entry.getValue();
    }
    return sumCount;
  }
}
