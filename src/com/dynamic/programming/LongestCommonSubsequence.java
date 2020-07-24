package com.dynamic.programming;

/**
 * Given two strings find the longest common sub sequence. Sub sequence need not
 * be contiguous but order to be maintained.
 * 
 * Input :
 * 
 * "ABACDY" "AYCYDY"
 * 
 * Output :
 * 
 * "ACDY"
 * 
 * @author srivatsav
 */

public class LongestCommonSubsequence {

	static int[][] memoization;

	public static void main(String[] args) {
		String x = "ABACDY";
		String y = "AYCYDY";

		int m = x.length();
		int n = y.length();

		memoization = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				memoization[i][j] = -1;
			}
		}

		int[][] dp = getLongestCommonSubSequence(x, y, m, n);
		// int longestSubSequenceLength = LCS(x, y, m, n);
		System.out.println("Longest Sub sequence length is :: " + dp[m][n]);

		printLongestCommonSubSequence(dp, m, n, x, y);
	}

	private static void printLongestCommonSubSequence(int[][] dp, int m, int n, String x, String y) {
		int i = m;
		int j = n;
		StringBuilder sb = new StringBuilder();

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				sb.append(x.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] < dp[i][j - 1])
					j--;
				else
					i--;
			}
		}

		System.out.println(sb.reverse().toString());
	}

	/**
	 * memoization technique
	 * 
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 */
	private static int LCS(String x, String y, int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		if (memoization[m][n] != -1)
			return memoization[m][n];

		if (x.charAt(n - 1) == y.charAt(m - 1)) {
			return memoization[m][n] = 1 + LCS(x, y, m - 1, n - 1);
		} else {
			return Math.max(LCS(x, y, m - 1, n), LCS(x, y, m, n - 1));
		}
	}

	private static int[][] getLongestCommonSubSequence(String x, String y, int m, int n) {

		int[][] dpTable = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dpTable[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
				} else {
					dpTable[i][j] = Math.max(dpTable[i][j - 1], dpTable[i - 1][j]);
				}
			}
		}

		return dpTable;

	}
}
