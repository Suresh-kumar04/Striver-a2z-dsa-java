import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = { 99, 11, 2, 44, 667, 0, -1, -9999 };
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  static void insertionSort(int[] arr) {
    //best case o(n) cuz while loop wont run
    //works good if array is partially sorted
    //thats why its used in hybrid sorthing
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
}
