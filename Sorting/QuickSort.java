import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] arr = { 2, 3, 41, 1, 5, 0, -1, -9990 };
    qs(arr, 0, arr.length - 1);
    IO.print(Arrays.toString(arr));
  }

  static void qs(int[] arr, int low, int high) {
    if (low >= high) return;
    int s = low,
      e = high,
      pivot = arr[s];
    while (s <= e) {
      //check if elements before pivot is smaller than pivot
      while (arr[s] < pivot) {
        s++;
      }
      //check if elements after pivot is greater than pivot
      while (arr[e] > pivot) {
        e--;
      }
      if (s <= e) {
        int t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
        s++;
        e--;
      }
    }
    qs(arr, low, e);
    qs(arr, s, high);
  }
}
