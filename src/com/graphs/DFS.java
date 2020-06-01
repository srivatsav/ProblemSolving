package com.graphs;

import java.util.ArrayList;

public class DFS {

  public static void main(String[] args) {
    int V = AdjacencyList.getVertices();
    boolean[] visited = new boolean[V + 1];
    printDFS(AdjacencyList.getAdjacencyList(), 0, visited);
  }

  static void printDFS(ArrayList<ArrayList<Integer>> adjaceArrayList, int S, boolean[] visited) {

    visited[S] = true;

    System.out.print(S + "-->");

    for (Integer u : adjaceArrayList.get(S)) {
      if (visited[u] == false) {
        printDFS(adjaceArrayList, u, visited);
      }
    }
  }

}