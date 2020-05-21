package com.arrays;
public class TrappingRainWater {

  public static void main(String[] args) {
    // For the given arr the trapped amount of water should be 5.
    int[] arr = { 2, 0, 3, 0, 5 };
    int trappedAmount = getTrappedAmountOfWater(arr, 5);
    System.out.println("The trapped amount of water is :: " + trappedAmount);
  }

  static int getTrappedAmountOfWater(int[] arr, int n) {
    int trappedAmount = 0;

    int[] leftMaxArr = new int[n];
    int[] rightMaxArr = new int[n];

    leftMaxArr[0] = arr[0];
    rightMaxArr[n - 1] = arr[n - 1];

    for (int i = 1; i < n; i++) {
      leftMaxArr[i] = Math.max(leftMaxArr[i - 1], arr[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      rightMaxArr[i] = Math.max(rightMaxArr[i + 1], arr[i]);
    }

    for (int i = 0; i < n; i++) {
      trappedAmount += Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
    }
    return trappedAmount;
  }

}