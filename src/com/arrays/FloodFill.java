package com.arrays;

public class FloodFill {

  public static void main(String[] args) {
    //    int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int[][] arr = {{0, 0, 0}, {0, 1, 1}};
    floodFillTheArray(arr, 1, 1, 1);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + "-->");
      }
      System.out.println();
    }
  }

  static void floodFillTheArray(int[][] arr, int sr, int sc, int newColour) {
    int rows = arr.length;
    int columns = arr[0].length;

    int n = arr[sr][sc];

    int i = sr, j = sc;

    if (i - 1 >= 0 && arr[i - 1][j] == n) {
      arr[i - 1][j] = -newColour;
      floodFillTheArray(arr, i - 1, j, newColour);
    }

    if (j - 1 >= 0 && arr[i][j - 1] == n ) {
      arr[i][j - 1] = -newColour;
      floodFillTheArray(arr, i, j - 1, newColour);
    }

    if (j + 1 < columns && arr[i][j + 1] == n) {
      arr[i][j + 1] = -newColour;
      floodFillTheArray(arr, i, j + 1, newColour);
    }

    if (i + 1 < rows && arr[i + 1][j] == n ) {
      arr[i + 1][j] = -newColour;
      floodFillTheArray(arr, i + 1, j, newColour);
    }

    return;
  }
}
