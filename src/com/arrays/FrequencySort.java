package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
  public static void main(String[] args) {
    System.out.println(frequencySort("cccaaa"));
  }

  static String frequencySort(String s) {
    if (s == null || s.isEmpty())
      return "";

    Map<Integer, String> map = new HashMap<Integer, String>();

    String result = "";

    int[] arr = new int[128];

    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i)]++;
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {

        int count = arr[i];

        StringBuilder sb = null;

        if (map.get(arr[i]) == null) {
          sb = new StringBuilder("");
          while (count > 0) {
            sb.append((char) i);
            count--;
          }
          map.put(arr[i], sb.toString());
        } else {
          sb = new StringBuilder(map.get(arr[i]));

          while (count > 0) {
            sb.append((char) i);
            count--;
          }
          map.put(arr[i], sb.toString());
        }
      }
    }

    for (int i = s.length(); i > 0; i--) {
      if (map.get(i) != null) {
        result = result.concat(map.get(i));
      }
    }

    return result;
  }
}