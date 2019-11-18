package com.binaryheap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an unsorted array, Find the K largest elements from the array.
 * 
 * @author srivatsav
 *
 * 
 */
public class KlargestElements {
	public static void main(String[] args) {
		int[] arr = { 30, 50, 1, 2, 80, 10 };
		int k = 3;
		printKLargestElements_MaxHeap(arr, k);
		printKLargestElements_MinHeap(arr, k);
	}

	/**
	 * Solution using MaxHeap.
	 * 
	 * @param arr
	 * @param k
	 * 
	 *            Complexity: O(n + k(log n))
	 */
	public static void printKLargestElements_MaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}

		for (int i = 0; i < k; i++) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();
	}

	/**
	 * Solution using MinHeap.
	 * 
	 * @param arr
	 * @param k
	 * 
	 *            Complexity: O(k + (n-k * log k))
	 */
	public static void printKLargestElements_MinHeap(int[] arr, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		// O(k)
		for (int i = 0; i < k; i++) {
			pQueue.add(arr[i]);
		}

		// (n-k) * logK
		for (int i = k; i < arr.length; i++) {
			int ele = pQueue.peek();
			if (arr[i] > ele) {
				pQueue.poll();
				pQueue.add(arr[i]);
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(pQueue.poll() + " ");
		}
		System.out.println();
	}
}
