package com.binaryheap;

/**
 * Binary heap .
 * 
 * @author srivatsav
 *
 */
public class BinaryHeap {

	private int[] heap;
	private int size;
	private int capacity;

	public BinaryHeap(int capacity) {
		this.heap = new int[capacity + 1];
		this.size = 0;
		this.capacity = capacity;
	}

	/**
	 * In case of MinHeap first element / root element is the Min. one.
	 * 
	 * @return
	 */
	private int getMin() {
		return this.heap[1];
	}

	/**
	 * Returns the parent of the current node.
	 * 
	 * @return
	 */
	private int getParent(int position) {
		return position / 2;
	}

	private int getLeftChild(int position) {
		return 2 * position;
	}

	private int getRightChild(int position) {
		return (2 * position) + 1;
	}

	private boolean isLeafNode(int position) {
		if (position >= (size / 2) && position <= size) {
			return true;
		}
		return false;
	}

	private void swapNodes(int fromPosition, int toPosition) {
		int temp = heap[fromPosition];
		heap[fromPosition] = heap[toPosition];
		heap[toPosition] = temp;
	}

	/**
	 * Extract the min element and remove it from the heap.
	 * 
	 * @return
	 */
	private int extractMin() {
		int poppedElement = heap[1];
		heap[1] = heap[size--];
		minHeapify(1);
		return poppedElement;
	}

	/**
	 * Min Heapify the Heap.
	 * 
	 * O(log n)
	 * 
	 * @param position
	 */
	private void minHeapify(int position) {

		if (heap[position] > heap[getLeftChild(position)] || heap[position] > heap[getRightChild(position)]) {
			
			if(heap[getLeftChild(position)] < heap[getRightChild(position)]) {
				swapNodes(position, getLeftChild(position));
				minHeapify(getLeftChild(position));
			} else {
				swapNodes(position, getRightChild(position));
				minHeapify(getRightChild(position));
			}

		}
	}
	
	/**
	 * Insertion in a heap.
	 * 
	 * @param element
	 */
	private void insert(int element) {		
		if(size >= capacity) {
			return;
		}
		heap[++size] = element;
		int current = size;
		while(heap[getParent(current)] > heap[current]) {
			swapNodes(current, getParent(current));
			current = getParent(current);
		}
	}
		
}
