public class SmallestPositiveMissingNumber {

  public static void main(String[] args) {

    int[] arr = { 28, 7, -36, 21, -21, -50, 9, -32 };

    int missingNumber = findMissingPositiveNumber(arr, arr.length);
    System.out.println("Missing Positive NUmber is :: " + missingNumber);
  }

  static int findMissingPositiveNumber(int[] arr, int size) {

    int count = segregate(arr, size);
    int[] arr2 = fetchAllPositiveArray(arr, count);

    int missingNumber = findMissingNumber(arr2);

    return missingNumber;
  }

  /**
   * Segregating all the zeros and negatives to the left of array.
   * 
   * @param arr
   * @param n
   * @return
   */
  private static int segregate(int[] arr, int n) {

    int j = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] <= 0) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }

    return j;
  }

  private static int[] fetchAllPositiveArray(int[] arr, int negativeCount) {
    int[] arr2 = new int[arr.length - negativeCount];
    int j = 0;
    for (int i = negativeCount; i < arr.length; i++) {
      arr2[j++] = arr[i];
    }
    return arr2;
  }

  private static int findMissingNumber(int[] arr) {

    int size = arr.length;

    for (int i = 0; i < size; i++) {
      int x = Math.abs(arr[i]);
      if (x - 1 < size && arr[x - 1] > 0) {
        arr[x - 1] = -arr[x - 1];
      }
    }

    for (int i = 0; i < size; i++)
      if (arr[i] > 0)
        return i + 1;

    return size + 1;
  }
}