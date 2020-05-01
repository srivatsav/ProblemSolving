
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
	public static void main(String[] args) {
		String x = "ABACDY";
		String y = "AYCYDY";

		int m = x.length();
		int n = y.length();

		int longestSubSequenceLength = getLongestCommonSubSequence(x, y, m, n);
		System.out.println("Longest Sub sequence length is :: " + longestSubSequenceLength);
	}

	private static int getLongestCommonSubSequence(String x, String y, int m, int n) {

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

		return dpTable[m][n];

	}
}
