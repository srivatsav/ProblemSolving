package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePaths {

  static List<List<Integer>> res = new ArrayList<List<Integer>>();

  public static void main(String[] args) {
    int[][] arr = { { 1, 2 }, { 3 }, { 3 }, {} };

    List<Integer> path = new ArrayList<Integer>();
    path.add(0);

    dfs(arr, 0, path);

    for (List<Integer> completePath : res) {
      for (int node : completePath) {
        System.out.print(node + "-->");
      }
      System.out.println();
    }

  }

  private static void dfs(int[][] graph, int u, List<Integer> path) {
    if (u == graph.length - 1) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < graph[u].length; i++) {
      int v = graph[u][i];
      path.add(v);
      dfs(graph, v, path);
      path.remove(path.size() - 1);
    }
  }
}