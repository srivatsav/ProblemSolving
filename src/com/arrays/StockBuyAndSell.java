package com.arrays;
public class StockBuyAndSell {
  public static void main(String[] args) {

    int[] arr = { 100, 180, 260, 310, 40, 535, 695 };
    int size = arr.length;

    findStockBuyAndSellIndexes(arr, size);
  }

  private static void findStockBuyAndSellIndexes(int[] arr, int size) {

    int[] leftMin = new int[size];
    int[] rightMax = new int[size];

    int k = 0;

    if (arr[0] < arr[1])
      leftMin[k++] = 0;

    for (int i = 1; i < size - 1; i++) {
      if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
        leftMin[k++] = i;
      }
    }

    k = 0;

    for (int i = 1; i < size - 1; i++) {
      if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
        rightMax[k++] = i;
      }
    }

    if (arr[size - 1] > arr[size - 2])
      rightMax[k++] = size - 1;

    for (int i = 0; i < size; i++) {
      if (leftMin[i] != 0 || rightMax[i] != 0) {
        System.out.println("Profit at :: (" + leftMin[i] + "," + rightMax[i] + ")");
      }

    }

  }
}