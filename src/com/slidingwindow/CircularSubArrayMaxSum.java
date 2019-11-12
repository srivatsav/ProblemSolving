package com.slidingwindow;

/**
 * Circular Sub array with max Sum.
 * 
 * Example: 
 * Input:
	3
	7
	8 -8 9 -9 10 -11 12
	8
	10 -3 -4 7 6 5 -4 -1
	8
	-1 40 -14 7 6 5 -4 -1
	
	Output:
	22
	23
	52
 * 
 * Explanation: 
 * 
 * Testcase 1: Starting from last element of the array, i.e, 12,
 * and moving in circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10,
 * which gives maximum sum as 22.
 * 
 * @author srivatsav
 *
 */
public class CircularSubArrayMaxSum {

	public static void main(String[] args) {
		int [] arr = {8, -8, 9, -9, 10, -11, 12};		
		int n = arr.length;
		System.out.println(maxSumCircularSubArray(arr, n));
	}

	private static int maxSumCircularSubArray(int[] arr, int n) {
		
		// Case when the corner elements are not included.
		int maxSum = kadane(arr,n);
		
		// Case when there is a max sum when corner elements are included.
		int maxWrappingSum = 0;
		for(int i=0;i<n;i++) {
			maxWrappingSum += arr[i];
			arr[i] = -arr[i];
		}
		maxWrappingSum = maxWrappingSum + kadane(arr, n);
		
		return Math.max(maxSum,  maxWrappingSum);
	}
	
	static int kadane(int []arr, int n) {
		int currentMax = 0, latestMax = 0;
		for(int i=0;i<n;i++)
		{
			currentMax += arr[i];
			if(currentMax < 0) {
				currentMax = 0;
			}
			if(currentMax > latestMax) {
				latestMax = currentMax;
			}
		}
		return latestMax;
	}
}
