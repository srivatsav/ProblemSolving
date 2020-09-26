package com.binaryheap;

import java.util.PriorityQueue;

public class MaxProfit {
    public static void main(String[] args) {
        int[] capitals = { 0, 1, 2 };
        int[] profits = { 1, 2, 3 };
        int numberOfProjects = 2;
        int initialCapital = 1;

        System.out.println(findMaxProfit(capitals, profits, numberOfProjects, initialCapital));
    }

    private static int findMaxProfit(int[] capitals, int[] profits, int maxProjects, int initialCapital) {
        if (maxProjects == 0)
            return 0;

        int n = profits.length;

        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i, j) -> capitals[i] - capitals[j]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i, j) -> profits[j] - profits[i]);

        // insert all project capitals in min heap.
        for (int i = 0; i < capitals.length; i++)
            minCapitalHeap.offer(i);

        int availableCapital = initialCapital;
        for (int i = 0; i < maxProjects; i++) {

            while (!minCapitalHeap.isEmpty() && capitals[minCapitalHeap.peek()] <= availableCapital)
                maxProfitHeap.add(minCapitalHeap.poll());

            if (maxProfitHeap.isEmpty())
                break;

            availableCapital += profits[maxProfitHeap.poll()];
        }

        return availableCapital;

    }
}
