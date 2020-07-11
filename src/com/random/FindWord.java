package com.random;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
 * word = "ABCB", return false.
 * 
 * 
 */
public class FindWord {

  public static void main(String[] args) {
    char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
    String word = "SEE";

    System.out.println(exist(board, word));
  }

  private static boolean exist(char[][] board, String word) {

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (word.charAt(0) == board[i][j]) {
          if (wordFound(board, i, j, word, 0))
            return true;
        }
      }
    }

    return false;
  }

  private static boolean wordFound(char[][] board, int i, int j, String word, int k) {

    // if word found
    if (k == word.length())
      return true;

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) {
      return false;
    }

    char temp = board[i][j];
    board[i][j] = '#';

    boolean found = wordFound(board, i - 1, j, word, k + 1) || wordFound(board, i + 1, j, word, k + 1)
        || wordFound(board, i, j - 1, word, k + 1) || wordFound(board, i, j + 1, word, k + 1);

    board[i][j] = temp;

    return found;
  }

}