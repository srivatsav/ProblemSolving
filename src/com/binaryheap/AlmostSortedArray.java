package com.binaryheap;

import java.util.PriorityQueue;

/**
 * Given a K and also given that every element is within K distance of it's
 * sorted position.
 * 
 * Input :- [9,8,7,18,19,17] K = 2
 *
 * Output :- [7,8,9,17,18,19]
 * 
 * @author srivatsav
 *
 */
public class AlmostSortedArray {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 18, 19, 17 };
		int k = 2;
		sortArray(arr, k);
	}

	public static void sortArray(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int outputIndex = 0;

		// Build a Min heap for the first k elements.
		for (int i = 0; i < k + 1; i++) {
			queue.add(arr[i]);
		}

		// Poll the min from the min heap and push the next element to the queue
		for (int i = k + 1; i < arr.length; i++) {
			arr[outputIndex++] = queue.poll();
			queue.add(arr[i]);
		}

		// Poll the elements remaining from the queue.
		while (!queue.isEmpty()) {
			arr[outputIndex++] = queue.poll();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
