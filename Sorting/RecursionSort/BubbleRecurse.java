package RecursionSort;

import java.util.Arrays;

public class BubbleRecurse {

  public static void main(String[] args) {
    int[] nums = { 2, 3, 4, 888, 0, -988 };
    pass(nums, nums.length);
    System.out.println(Arrays.toString(nums));
  }

  static void pass(int[] nums, int n) {
    if (n <= 1) return;
    boolean swapped = sort(nums, 0, n - 1);
    if (!swapped) return;
    pass(nums, n - 1);
  }

  static boolean sort(int[] arr, int j, int end) {
    if (j >= end) return false;
    boolean changed = false;
    if (arr[j + 1] < arr[j]) {
      int t = arr[j];
      arr[j] = arr[j + 1];
      arr[j + 1] = t;
      changed = true;
    }

    boolean rest = sort(arr, j + 1, end);
    return changed || rest;
  }
}
