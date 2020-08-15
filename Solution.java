import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    int[] arr = { 2, 7, 11, 15 };
    int target = 9;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        System.out.println(map.get(arr[i]) + "--->" + i);
        return;
      } else {
        map.put(target - arr[i], i);
      }
    }
  }
}