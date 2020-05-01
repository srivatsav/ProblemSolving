public class RotateArray {
  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 4, 5 };
    int rotationCount = 3;
    rotateArray(arr, rotationCount);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "->");
    }
  }

  static void rotateArray(int[] arr, int n) {

    reverseArray(arr, 0, n - 1);
    reverseArray(arr, n, arr.length - 1);
    reverseArray(arr, 0, arr.length - 1);
  }

  static void reverseArray(int[] arr, int begin, int end) {

    while (begin < end) {
      swap(arr, begin, end);
      begin++;
      end--;
    }

  }

  static void swap(int[] a, int low, int high) {
    int temp = a[low];
    a[low] = a[high];
    a[high] = temp;
  }
}