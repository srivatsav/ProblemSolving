package com.graphs;

import java.util.ArrayList;

public class CycleInGraph {
  public static void main(String[] args) {
    int V = 3;
    int[][] arr = { { 1, 0 }, { 0, 2 }, { 2, 1 } };
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < arr.length; i++) {
      graph.get(arr[i][0]).add(arr[i][1]);
    }

    boolean[] visited = new boolean[V + 1];

    if (helper(V, visited, graph))
      System.out.print("The courses can be completed");
    else
      System.out.print("The courses cannot be completed");

  }

  public static boolean helper(int V, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
    for (int i = 0; i < V; i++) {
      if (!visited[i] && graph.get(i).size() > 0) {
        if (dfs(graph, i, visited, -1))
          return false;
      }
    }
    return true;
  }

  public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int V, boolean[] visited, int parent) {
    visited[V] = true;

    for (int adjacent : adj.get(V)) {
      if (!visited[adjacent]) {
        return dfs(adj, adjacent, visited, V);
      } else if (adjacent == parent) {
        return true;
      }
    }
    return false;
  }
}