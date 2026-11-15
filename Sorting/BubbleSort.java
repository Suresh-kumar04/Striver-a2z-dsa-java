package Sorting;
import java.util.Arrays;
public class BubbleSort {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int[] arr = { 2, 3, 5, 2, 1, 9999, 0 };
    bubbleSort(arr);
    long endTime = System.nanoTime();
    long sortingTime = endTime - startTime;
    System.out.println("Bubble Sort Time: " + sortingTime + " nanoseconds");
    System.out.println(Arrays.toString(arr));
  }

  static void bubbleSort(int[] arr) {
    //bubble sort means push the largest to the end each iteration thats why -1-i

    for (int i = 0; i < arr.length - 1; i++) {
      boolean bool = false;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
          bool = true;
        }
      }
      if (!bool) break;
    }
  }
}
