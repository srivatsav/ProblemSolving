package com.arrays;

public class MaxAreaContainer {
  public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//    int[] arr = {0,0,2};
    System.out.print("Max Area is ::" + maxArea(arr));
  }

  static int maxArea(int[] height) {

    int n = height.length;
    int[] leftArray = new int[n];
    int[] rightArray = new int[n];
    int maxAmount=0;

    leftArray[0] = height[0];
    rightArray[n - 1] = height[n - 1];

    for(int i=1;i<n;i++)
    {
      leftArray[i] = Math.max(leftArray[i-1],height[i]);
    }

    for(int i=n-2;i>=0;i--){
      rightArray[i] = Math.max(rightArray[i+1], height[i]);
    }

    for(int i=0;i<n;i++){
      maxAmount = Math.max(maxAmount, Math.min(leftArray[i],rightArray[i])-height[i]);
    }
    return maxAmount;

  }
}
