package com.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a queue of integers of even length, rearrange the elements by
 * interleaving the first half of the queue with the second half of the queue.
 * 
 * Only a stack can be used as an auxiliary space.
 * 
 * Examples:
 * 
 * Input : 1 2 3 4 Output : 1 3 2 4
 * 
 * Input : 11 12 13 14 15 16 17 18 19 20 Output : 11 16 12 17 13 18 14 19 15 20
 */
public class QueueInterleaving {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);

        interleave(q);
    }

    private static void interleave(Queue<Integer> q) {

        int size = q.size();

        if (size % 2 != 0)
            return;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size / 2; i++) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        // 16 17 18 19 20 15 14 13 12 11

        for (int i = 0; i < size / 2; i++) {
            q.add(q.poll());
        }

        // 15 14 13 12 11 16 17 18 19 20
        for (int i = 0; i < size / 2; i++) {
            stack.push(q.poll());
        }
        // 11 12 13 14 15
        // 16 17 18 19 20

        while (!stack.isEmpty()) {
            q.offer(stack.pop());
            q.offer(q.poll());
        }
    }
}
