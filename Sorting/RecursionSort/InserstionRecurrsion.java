package RecursionSort;

import java.util.Arrays;

public class InserstionRecurrsion {

  public static void main(String[] args) {
    int[] arr = { 55, 66, 2, 1, 0, -999, 2, 2, 2, 334 };
    pass(arr, 0, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  static void pass(int[] arr, int start, int end) {
    if (start >= end) return;
    sort(arr, start - 1, arr[start]);
    pass(arr, start + 1, end);
  }

  static void sort(int[] arr, int j, int key) {
    if (j >= 0 && arr[j] > key) {
      arr[j + 1] = arr[j];
      sort(arr, j - 1, key);
    } else {
      arr[j + 1] = key;
    }
  }
}
