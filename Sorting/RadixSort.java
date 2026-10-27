
public class RadixSort {

  public static void main(String[] args) {
    int arr[] = {
      893,
      999,
      231,
      1,
      0,
      11,
      929929,
      22222222,
      33333,
      21,
      1221,
      22,
    };

    int max = 0;

    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }


    for (int i = 1; max / i > 0; i *= 10) {
      radix(arr, i);
    }

  }
  static void radix(int[] arr, int lastDigit) {
    int[] count = new int[10];

    for (int i = 0; i < arr.length; i++) {
      int digit = (arr[i] / lastDigit) % 10;
      count[digit]++;
    }

    // turn count to cumulative array
    for (int i = 1; i < 10; i++) {
      count[i] = count[i] + count[i - 1];
    }

    // traverse from last to maintain stability
    int[] res = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      int digit = (arr[i] / lastDigit) % 10;
      res[count[digit] - 1] = arr[i];
      count[digit]--;
    }

    System.arraycopy(res, 0, arr, 0, arr.length);
  }
}
