package com.arrays;

public class SortedSquares {
  public static void main(String[] args) {
    //    int[] arr = {-4, -1, 0, 3, 10};
//        int [] arr = {-7, -3, 2, 3, 11};
//      int [] arr = {-71, -3, 2, 3, 11};
//  int [] arr = {-3,-2,0,2,3};
    int [] arr = {-7,-6,1,2};
//    int [] arr = {-11,-2,3,4};
    sortSquares(arr, arr.length);
  }

  static void sortSquares(int[] arr, int size) {
    int index;
    for (index = 0; index < size; index++) {
      if (arr[index] >= 0) {
        break;
      }
    }

    int index1 = index - 1;
    int index2 = index;

    int k = 0;

    int[] temp = new int[size];

    while (index1 >= 0 && index2 < size) {
      if (arr[index1] * arr[index1] < arr[index2] * arr[index2]) {
        temp[k++] = arr[index1] * arr[index1];
        index1--;
      } else {
        temp[k++] = arr[index2] * arr[index2];
        index2++;
      }
    }

    while (index1 >= 0) {
      temp[k++] = arr[index1] * arr[index1];
      index1--;
    }

    while (index2 < size) {
      temp[k++] = arr[index2] * arr[index2];
      index2++;
    }

    for (int i = 0; i < temp.length; i++) {
      System.out.println(temp[i]);
    }
  }
}
