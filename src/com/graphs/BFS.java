package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static void main(String[] args) {
    printBfs(AdjacencyList.getAdjacencyList(), AdjacencyList.getVertices(), 0);
  }

  static void printBfs(ArrayList<ArrayList<Integer>> adjacencyList, int V, int source) {

    boolean[] visited = new boolean[V + 1];

    Queue<Integer> queue = new LinkedList<>();

    visited[source] = true;

    queue.add(source);

    while (!queue.isEmpty()) {
      int front = queue.poll();

      System.out.print(front + "->");

      for (Integer v : adjacencyList.get(front)) {
        if (!visited[v]) {
          visited[v] = true;
          queue.add(v);
        }
      }
    }

  }
}