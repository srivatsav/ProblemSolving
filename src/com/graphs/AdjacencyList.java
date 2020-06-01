package com.graphs;

import java.util.ArrayList;

public class AdjacencyList {

  static ArrayList<ArrayList<Integer>> adjacencyList;
  static int vertices = 5;

  public static void main(String[] args) {
    getAdjacencyList();
  }

  static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  public static ArrayList<ArrayList<Integer>> getAdjacencyList() {
    adjacencyList = new ArrayList<ArrayList<Integer>>(vertices);

    for (int i = 0; i < vertices; i++)
      adjacencyList.add(new ArrayList<Integer>());

    addEdge(adjacencyList, 0, 1);
    addEdge(adjacencyList, 0, 2);
    addEdge(adjacencyList, 1, 2);
    addEdge(adjacencyList, 1, 3);
    return adjacencyList;
  }

  public static int getVertices() {
    return vertices;
  }
}