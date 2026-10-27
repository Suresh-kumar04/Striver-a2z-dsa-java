import java.util.Arrays;

public class CyclicSort {

  public static void main(String[] args) {
    int[] arr = { 7, 6, 1, 2, 3, 5, 4 };
    sort(arr);
    System.out.println(arr.getClass());
    System.out.println(Arrays.toString(arr));
  }

  static void sort(int[] arr) {
    //o(n-1 + n) = o(n)
    int i = 0;
    while (i < arr.length) {
      int correctIndex = arr[i] - 1;
      if (arr[i] != arr[correctIndex]) {
        Swap.swap(arr, i, correctIndex);
      } else {
        i++;
      }
    }
  }
}
