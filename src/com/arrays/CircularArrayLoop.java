package com.arrays;

public class CircularArrayLoop {
  public static void main(String[] args) {

    int[] arr = { 1, 2, -1, 2, 2 };

    System.out.println(checkIfLoopExists(arr));
  }

  private static boolean checkIfLoopExists(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean isForward = arr[i] >= 0;
      int slow = i, fast = i; // 0, 0
      do {
        slow = findNextIndex(slow, arr, isForward); // 0
        fast = findNextIndex(fast, arr, isForward); // 3
        if (fast != -1)
          fast = findNextIndex(fast, arr, isForward); // 0
      } while (slow != -1 && fast != -1 && slow != fast);

      if (slow != -1 && slow == fast)
        return true;
    }
    return false;
  }

  private static int findNextIndex(int currIdx, int[] arr, boolean isForward) {

    boolean direction = arr[currIdx] >= 0;
    if (direction != isForward)
      return -1;

    int nextIndex = (currIdx + arr[currIdx]) % arr.length;
    if (nextIndex < 0) {
      nextIndex += arr.length;
    }
    if (currIdx == nextIndex)
      return -1;

    return nextIndex;
  }
}