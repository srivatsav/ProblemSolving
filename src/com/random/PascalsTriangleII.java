package com.random;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
  public static void main(String[] args) {
    printPascal(3);
  }

  private static void printPascal(int rowIndex) {
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i <= rowIndex; i++) {
      int j = 0;
      while (res.size() - 1 > j) {
        res.add(res.get(0) + res.get(1));
        res.remove(0);
        j++;
      }
      res.add(1);
    }
    for (Integer n : res)
      System.out.print(n + "-->");
  }
}