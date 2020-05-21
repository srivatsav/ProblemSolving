package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderArray {

  public static void main(String[] args) {
    int[][] arr = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };

    printArrayInSpiralOrder(arr, arr.length, arr[0].length);
  }

  private static List<Integer> printArrayInSpiralOrder(int[][] matrix, int rows, int columns) {

    List<Integer> result = new ArrayList<Integer>();

    int currentRow = 0, currentColumn = 0;

    if (rows == 0) return result;

    while (currentRow < rows && currentColumn < columns) {

      for (int i = currentColumn; i < columns; i++) {
        result.add(matrix[currentRow][i]);
      }
      currentRow++;

      for (int i = currentRow; i < rows; i++) {
        result.add(matrix[i][columns - 1]);
      }
      columns--;

      if (currentRow < rows) {
        for (int i = columns - 1; i >= currentColumn; i--) {
          result.add(matrix[rows - 1][i]);
        }
        rows--;
      }

      if (currentColumn < columns) {
        for (int i = rows - 1; i >= currentRow; i--) {
          result.add(matrix[i][currentColumn]);
        }
        currentColumn++;
      }
    }

    return result;
  }
}
