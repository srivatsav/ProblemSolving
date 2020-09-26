package com.binaryheap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 10, 15, 50, 4, 20 };
        int size = arr.length;
        int idx = (size / 2) - 1;

        for (int i = idx; i >= 0; i--) {
            maxHeapify(arr, i, size);
        }

        // 15 , 20, 10, 4, 50
        for (int i = size - 1; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }

        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + "-->");

    }

    private static void maxHeapify(int[] arr, int i, int n) {
        int largestChild = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largestChild])
            largestChild = leftChild;
        if (rightChild < n && arr[rightChild] > arr[largestChild])
            largestChild = rightChild;

        if (largestChild != i) {
            swap(arr, largestChild, i);
            maxHeapify(arr, largestChild, n);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
