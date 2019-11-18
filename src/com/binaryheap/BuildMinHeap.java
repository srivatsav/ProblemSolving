package com.binaryheap;

public class BuildMinHeap {

	public static void main(String[] args) {
		int[] arr = { 15, 10, 3, 2, 8, 7 };
		int size = arr.length;
		int index = (size / 2) - 1;
		for (int i = index; i >=0; i--) {
			heapify(i, arr);
		}

		for (int i = 0; i < size/2; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void heapify(int position, int[] arr) {

		if (2 * position >= arr.length)
			return;

		int leftChild = 2 * position;
		int rightChild = 2 * position + 1;

		if (arr[position] > arr[leftChild] || arr[position] > arr[rightChild]) {

			if (arr[leftChild] < arr[rightChild]) {
				swap(position, 2 * position, arr);
				heapify(2 * position , arr);
			} else {
				swap(position, 2 * position + 1, arr);
				heapify(2 * position + 1, arr);
			}
		}
	}

	private static void swap(int from, int to, int[] arr) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

}
