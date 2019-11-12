package com.slidingwindow;
/**
 * Max Sum Sub array of size k.
 * 
 * @author srivatsav
 *
 */
public class SubArraySumGivenSize {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 30, -5, 20, 7 };
		int n = arr.length;
		int k = 3;

		int maxSumFound = maxSumSubArray(arr, n, k);
		System.out.println(maxSumFound);
	}

	private static int maxSumSubArray(int[] arr, int n, int k) {
		int currentSum = 0;

		for (int i = 0; i < k; i++)
			currentSum += arr[i];

		int maxSum = currentSum;

		for (int i = k; i < n; i++) {
			currentSum += arr[i] - arr[i - k];
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}
}
