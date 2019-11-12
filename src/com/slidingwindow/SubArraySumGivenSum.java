package com.slidingwindow;
/**
 * Find Sub Array with given sum.
 * 
 * @author srivatsav
 *
 */
public class SubArraySumGivenSum {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 30, 5, 20, 7 };
		int n = arr.length;
		int givenSum = 27;

		System.out.println(getSubArrayWithGivenSum(arr, n, givenSum));
	}

	private static boolean getSubArrayWithGivenSum(int[] arr, int n, int givenSum) {
		int currentSum = arr[0], start = 0;

		for (int i = 1; i <=n; i++) {
			while (currentSum > givenSum && start < i - 1) {
				currentSum -= arr[start++];
			}
			if (currentSum == givenSum) {
				int end = i - 1;
				System.out.println("INdexes found at " + start + "and" + end);
				return true;
			}

			if (i < n)
				currentSum += arr[i];
		}

		return currentSum == givenSum;
	}
}
