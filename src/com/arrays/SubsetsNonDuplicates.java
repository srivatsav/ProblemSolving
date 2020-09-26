package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of numbers that might contain duplicates, find all of its
 * distinct subsets.
 * 
 * Example 1:
 * 
 * Input: [1, 3, 3] Output: [], [1], [3], [1,3], [3,3], [1,3,3] Example 2:
 * 
 * Input: [1, 5, 3, 3] Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3],
 * [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 * 
 */
public class SubsetsNonDuplicates {
    public static void main(String[] args) {

        int[] arr = { 1, 5, 3, 3 };

        List<List<Integer>> subsets = generateNonDuplicateSubSets(arr);
        for (List<Integer> subset : subsets) {
            for (Integer n : subset) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> generateNonDuplicateSubSets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();

        Arrays.sort(arr);

        subsets.add(new ArrayList<>());

        int startIdx = 0;

        while (startIdx < arr.length) {
            if (startIdx > 0 && arr[startIdx] == arr[startIdx - 1]) {
                startIdx++;
                continue;
            }

            int size = subsets.size();

            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(arr[startIdx]);
                subsets.add(subset);
            }

            startIdx++;
        }

        return subsets;
    }
}
