package com.trie;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {

  public static void main(String[] args) {
    char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
    String[] words = { "oath", "pea", "eat", "rain" };

    Trie trie = new Trie();

    for (String word : words) {
      trie.insert(word);
    }

    boolean[][] visited = new boolean[board.length][board[0].length];
    dfs(board, 0, 0, visited);

  }

  StringBuilder sb = new StringBuilder();

  private static void dfs(char[][] board, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
      return;
  }

}

class Trie {
  Node root;

  Trie() {
    root = new Node('#');
  }

  /**
   * Insert word into trie
   * 
   * @param word
   */
  public void insert(String word) {
    Node currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      currentNode = currentNode.getChildNode(word.charAt(i));
    }
    currentNode.makeLeaf();
  }

  public boolean search(String word) {
    Node currentNode = checkIfExists(root, word);
    return currentNode != null && currentNode.isLeaf();
  }

  public boolean startsWith(String prefix) {
    Node currentNode = checkIfExists(root, prefix);
    return currentNode != null;
  }

  public Node checkIfExists(Node currentNode, String word) {
    for (int i = 0; i < word.length(); i++) {
      char value = word.charAt(i);
      if (!currentNode.containsChild(value))
        return null;
      currentNode = currentNode.getChildNode(value);
    }
    return currentNode;
  }

}

class Node {
  Character value;
  Map<Character, Node> children;
  boolean leaf;

  Node(Character value) {
    this.value = value;
    this.leaf = false;
    this.children = new HashMap<>();
  }

  public boolean isLeaf() {
    return leaf;
  }

  public Character getValue() {
    return value;
  }

  public Node getChildNode(Character val) {
    if (children.get(val) == null) {
      children.put(val, new Node(val));
    }
    return children.get(val);
  }

  public void makeLeaf() {
    this.leaf = true;
  }

  public boolean containsChild(Character value) {
    return children.containsKey(value);
  }
}