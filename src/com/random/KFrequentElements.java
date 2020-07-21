package com.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KFrequentElements {

  public static void main(String[] args) {
    int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
    int k = 10;
    topKFrequent(nums, k);
  }

  private static int[] topKFrequent(int[] nums, int k) {

    if (nums == null || nums.length == 0)
      return new int[1];

    Map<Integer, Integer> frequencyMap = new HashMap<>();
    int maxFrequency = Integer.MIN_VALUE;

    for (Integer num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
      maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
    }

    Map<Integer, List<Integer>> nMap = new HashMap<Integer, List<Integer>>();

    for (Integer num : nums) {
      int frequency = frequencyMap.get(num);

      if (nMap.get(frequency) == null) {
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(num);
        nMap.put(frequency, temp);
      } else if (!nMap.get(frequency).contains(num)) {
        List<Integer> temp = nMap.get(frequency);
        temp.add(num);
        nMap.put(frequency, temp);
      }
    }

    List<Integer> res = new ArrayList<Integer>();

    while (k > 0) {
      List<Integer> list = nMap.get(maxFrequency--);

      if (list != null && list.size() > 0) {
        if (list.size() > k) {
          list.remove(list.size() - k);
          res.addAll(list);
          break;
        }

        if (list.size() == k) {
          res.addAll(list);
          break;
        }

        res.addAll(list);
        k = k - list.size();
      }
    }

    int[] arr = new int[res.size()];
    for (int i = 0; i < arr.length; i++)
      arr[i] = res.get(i);

    return arr;
  }

}