package DutchFlagDijstra;

import java.util.Arrays;

public class dutchFlag {

  public static void main(String[] args) {
    dutchFlag df = new dutchFlag();
    // sort array with 0,1,2,
    int[] arr = { 1, 0, 0, 2, 2, 2, 1, 2, 0 };
    df.dutchFlag(arr);
    System.out.println(Arrays.toString(arr));
  }

  void dutchFlag(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;
    while (mid <= high) {
      if (arr[mid] == 0) {
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
        high--;
      }
    }
  }
}
