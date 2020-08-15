package com.arrays;

public class StockBuyAndSell {
  public static void main(String[] args) {

    // int[] arr = { 100, 180, 260, 310, 40, 535, 695 };
    int[] arr = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
    int size = arr.length;

    findStockBuyAndSellIndexes(arr, size);

  }

  private static void findStockBuyAndSellIndexes(int[] price, int n) {

    int buyAt = -1;
    int sellAt = -1;
    int i = 0;

    StringBuffer sb = new StringBuffer();
    while (i < n - 1) {
      while (i < n - 1 && price[i + 1] <= price[i]) {
        i++;
      }
      if (i == n - 1) {
        break;
      }
      buyAt = i;

      while (i < n - 1 && price[i + 1] >= price[i]) {
        i++;
      }
      sellAt = i;
      sb.append("(" + buyAt + " " + sellAt + ") ");
    }

    System.out.println(sb.toString());

  }

}