package com.design.priorityqueue;

import java.util.Arrays;

public class PriorityMessageQueue<T extends Comparable> {

    private int size = 0;
    private int capacity;

    private Message[] queue;

    public PriorityMessageQueue(Message[] queue) {
        this.queue = queue;
        this.capacity = queue.length;
    }

    public Message remove() {
        if (isEmpty())
            return null;

        final var root = queue[0];
        queue[0] = queue[size - 1];
        size--;

        for (int i = size / 2 - 1; i >= 0; i--)
            maxHeapify(i);

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Message message) {
        ensureCapacity();
        queue[size] = message;
        size++;
        for (int i = size / 2 - 1; i >= 0; i--)
            maxHeapify(i);

    }

    public void maxHeapify(int idx) {

        int largeChild = idx;
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;

        if (leftChild < size && queue[leftChild] != null && queue[leftChild].compareTo(queue[largeChild]) < 0) {
            largeChild = leftChild;
        }
        if (rightChild < size && queue[rightChild] != null && queue[rightChild].compareTo(queue[largeChild]) < 0) {
            largeChild = leftChild;
        }

        if (largeChild != idx) {
            swap(largeChild, idx);
            maxHeapify(largeChild);
        }

    }

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            queue = Arrays.copyOf(queue, capacity);
        }
    }

    private int parentIndex(int position) {
        return (position - 1) / 2;
    }

    private int leftChildIndex(int position) {
        return 2 * position + 1;
    }

    private int rightChildIndex(int position) {
        return 2 * position + 2;
    }

    private void swap(int start, int end) {
        Message temp = queue[start];
        queue[start] = queue[end];
        queue[end] = temp;
    }

    private boolean hasParent(int idx) {
        return parentIndex(idx) >= 0;
    }

    private Message parent(int idx) {
        return queue[parentIndex(idx)];
    }

}
