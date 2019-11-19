package com.binaryheap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Kth largest element from a stream of data.
 * 
 * [ 5, 15, 6, 3, 10, 20, ........ ]
 * 
 * K = 3
 * 
 * [ __, __, 5, 5, 6, 10, ........ ]
 * 
 * @author srivatsav
 *
 */
public class KthLargestInStream {

	public static void main(String[] args) {

		int[] arr = { 5, 15, 6, 3, 10, 20 };
		int n = arr.length;
		int k = 3;

		int [] res = getKthLargestElement(arr, n, k);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}

	private static int[] getKthLargestElement(int[] arr, int n, int k) {
		int [] res = new int[n];
		int resultIndex = 0;
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			pQueue.add(arr[i]);
		}
		
		res[resultIndex++] = pQueue.peek();
		
		for(int i=k;i<n;i++) {
			if(pQueue.peek() < arr[i]) {
				pQueue.poll();
				pQueue.add(arr[i]);
				res[resultIndex++] = arr[i];
			}else {
				res[resultIndex++] = pQueue.peek();
			}
		}
		
		res[resultIndex++] = pQueue.peek();
		
		return res;
	}
}
