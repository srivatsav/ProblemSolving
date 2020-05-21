package com.arrays;
public class ReverseArray {

  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 4, 5, 6 };

    reverseArray(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "->");
    }
  }

  static void reverseArray(int[] arr, int size) {
    int end = size - 1;

    for (int i = 0; i < size / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[end];
      arr[end] = temp;
      end--;
    }
  }

}