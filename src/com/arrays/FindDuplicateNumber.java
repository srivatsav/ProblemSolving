package com.arrays;

public class FindDuplicateNumber {

  public static void main(String[] args) {
    int[] arr = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};

    System.out.println(findDuplicates(arr));
  }

  static int findDuplicates(int[] arr) {
    int t = arr[0];
    int h = arr[0];

    do {
      t = arr[t];
      h = arr[arr[h]];
    } while (t != h);

    t = arr[0];
    while (t != h) {
      t = arr[t];
      h = arr[h];
    }

    return h;
  }
}
