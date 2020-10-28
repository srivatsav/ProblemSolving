package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array. A k-diff pair is an integer pair (nums[i],
 * nums[j]), where the following are true:
 * 
 * Input: nums = [3,1,4,1,5], k = 2 Output: 2 Explanation: There are two 2-diff
 * pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the input,
 * we should only return the number of unique pairs.
 * 
 */
public class KDiffPairs {
    public static void main(String[] args) {

        int[] arr = { 3, 1, 4, 1, 5 };
        int k = 0;

        // (1,2) (2,3) (3,4) (4,5)

        System.out.println(findKDiffPairs(arr, k));
    }

    private static int findKDiffPairs(int[] arr, int k) {
        int numOfPairs = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (int key : map.keySet()) {
            if ((k > 0 && map.containsKey(key - k)) || (k == 0 && map.get(key) >= 2)) {
                numOfPairs++;
            }
        }

        return numOfPairs;
    }
}
