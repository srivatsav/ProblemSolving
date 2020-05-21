package com.arrays;

public class GameOfLife {

  public static void main(String[] args) {
    int[][] board = {
      {0, 1, 0},
      {0, 0, 1},
      {1, 1, 1},
      {0, 0, 0}
    };

    gameOfLife(board);
  }

  public static void gameOfLife(int[][] board) {

    int rows = board.length;
    int columns = board[0].length;

    int x = 0, y = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        calculateNextStage(board, i, j, rows, columns);
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (board[i][j] == -1) board[i][j] = 0;
        else if (board[i][j] == -2) board[i][j] = 1;
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(board[i][j] + "->");
      }
      System.out.println();
    }
  }

  static void calculateNextStage(int[][] board, int i, int j, int rows, int columns) {
    int liveNeighbourCount = 0;

    if (i - 1 >= 0 && j - 1 >= 0) {
      if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1) liveNeighbourCount++;
    }
    if (i - 1 >= 0 && j >= 0) {
      if (board[i - 1][j] == 1 || board[i - 1][j] == -1) liveNeighbourCount++;
    }
    if (i - 1 >= 0 && j + 1 < columns) {
      if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1) liveNeighbourCount++;
    }

    if (i >= 0 && j - 1 >= 0) {
      if (board[i][j - 1] == 1 || board[i][j - 1] == -1) liveNeighbourCount++;
    }
    if (i >= 0 && j + 1 < columns) {
      if (board[i][j + 1] == 1 || board[i][j + 1] == -1) liveNeighbourCount++;
    }

    if (i + 1 < rows && j - 1 >= 0) {
      if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1) liveNeighbourCount++;
    }

    if (i + 1 < rows && j >= 0) {
      if (board[i + 1][j] == 1 || board[i + 1][j] == -1) liveNeighbourCount++;
    }

    if (i + 1 < rows && j + 1 < columns) {
      if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1) liveNeighbourCount++;
    }

    if (board[i][j] == 1 && (liveNeighbourCount < 2 || liveNeighbourCount > 3)) board[i][j] = -1;
    else if (board[i][j] == 0 && liveNeighbourCount == 3) board[i][j] = -2;
  }
}
