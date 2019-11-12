package com.slidingwindow;

/**
 * fibonacci - sum of previous 2 numbers
 * tribonacci - sum of previous 3 numbers
 * . 
 * .
 * .
 * NBonacci - sum of previous n numbers
 * 
 * Print first M NBonacci numbers.
 * 
 * @author srivatsav
 *
 */
public class NBonacciNumbers {
	public static void main(String[] args) {
		int n = 3;
		int m = 10;

		printNBonacciNumbers(n, m);
	}

	private static void printNBonacciNumbers(int n, int m) {

		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = 0;
		}
		arr[n - 1] = 1;
		arr[n] = 1;

		for (int i = n + 1; i < m; i++) {
			arr[i] = 2 * arr[i - 1] - arr[i - n - 1];
		}

		for (int i = 0; i < m; i++) {
			System.out.println(arr[i]);
		}
	}
}
