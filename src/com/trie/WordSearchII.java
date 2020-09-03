package com.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
  public static void main(String[] args) {
    char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };

    String[] words = { "oath", "pea", "eat", "rain" };

    List<String> res = findWord(board, words);

    for (String matchedWords : res) {
      System.out.println(matchedWords);
    }
  }

  private static List<String> findWord(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();

    Node root = buildTrie(words);

    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, i, j, root, res);
      }
    }
    return res;
  }

  private static void dfs(char[][] board, int i, int j, Node node, List<String> res) {

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#')
      return;

    char c = board[i][j];

    if (node.trieNodes[c - 'a'] == null)
      return;

    node = node.trieNodes[c - 'a'];

    if (node != null && node.word != null) {
      res.add(node.word);
      node.word = null;
    }

    board[i][j] = '#';

    dfs(board, i - 1, j, node, res);
    dfs(board, i + 1, j, node, res);
    dfs(board, i, j - 1, node, res);
    dfs(board, i, j + 1, node, res);

    board[i][j] = c;
  }

  private static Node buildTrie(String[] words) {
    Node root = new Node();
    for (String word : words) {
      Node current = root;
      for (char c : word.toCharArray()) {
        if (current.trieNodes[c - 'a'] == null) {
          current.trieNodes[c - 'a'] = new Node();
        }
        current = current.trieNodes[c - 'a'];
      }
      current.word = word;
    }
    return root;
  }
}

class Node {

  String word;
  final Node[] trieNodes = new Node[26];

}