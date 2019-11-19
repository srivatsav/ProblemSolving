package com.binaryheap;

/**
 * Merge the given number of sorted arrays.
 * 
 * Input : { { 5, 10 }, { 2, 3, 15 }, { 1, 25, 30, 40 } }
 * 
 * Output : { 1, 2, 3, 5, 10, 15, 25, 30, 40 }
 * 
 * @author srivatsav
 *
 */

class MinHeapNode {

	int element;
	int index;
	int next;

	public MinHeapNode(int element, int index, int next) {
		this.element = element;
		this.index = index;
		this.next = next;
	}
}

class MinHeap {
	MinHeapNode[] heapNodes;
	int heapSize;

	public MinHeap(MinHeapNode[] nodes, int heapSize) {
		this.heapNodes = nodes;
		this.heapSize = heapSize;
		minHeapify(0);
	}

	private void minHeapify(int position) {

		if (2 * position + 1 >= heapSize)
			return;

		int current = heapNodes[position].element;
		int left = heapNodes[(2 * position) + 1].element;
		int right = heapNodes[(2 * position) + 2].element;

		if (current > left || current > right) {
			if (left < right) {
				swap(position, (2 * position) + 1);
				minHeapify(2 * position + 1);
			} else {
				swap(position, (2 * position) + 2);
				minHeapify(2 * position + 2);
			}
		}

	}

	private void swap(int from, int to) {
		MinHeapNode temp = heapNodes[from];
		heapNodes[from] = heapNodes[to];
		heapNodes[to] = temp;
	}

	public MinHeapNode peek() {
		return heapNodes[0];
	}

	public void replaceRoot(MinHeapNode node) {
		heapNodes[0] = node;
		minHeapify(0);
	}
}

public class MergeKSortedArrays {

	public static void main(String[] args) {
		int[][] matrix = { { 5, 10 }, { 2, 3, 15 }, { 1, 25, 30, 40 } };
		int k = 3;
		mergeKSortedArrays(matrix, k);
	}

	private static void mergeKSortedArrays(int[][] arr, int k) {
		MinHeapNode[] nodes = new MinHeapNode[k];
		int resultArraySize = 0;

		for (int i = 0; i < arr.length; i++) {
			MinHeapNode node = new MinHeapNode(arr[i][0], i, 1);
			nodes[i] = node;
			resultArraySize += arr[i].length;
		}

		MinHeap minHeap = new MinHeap(nodes, k);
		int[] sortedArray = new int[resultArraySize];

		for (int i = 0; i < resultArraySize; i++) {
			MinHeapNode minNode = minHeap.peek();
			int minElem = minNode.element;
			sortedArray[i] = minElem;

			if (minNode.next < arr[minNode.index].length) {
				minNode.element = arr[minNode.index][minNode.next++];
			} else {
				minNode.element = Integer.MAX_VALUE;
			}

			minHeap.replaceRoot(minNode);
		}

		for (int i = 0; i < resultArraySize; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}
}
