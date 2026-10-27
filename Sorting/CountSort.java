import java.util.Arrays;

public class CountSort {

  public static void main(String[] args) {
    int[] arr = { 2, 3, 99, 1, 2, 66, 44, 1, 5, 5, 7 };
    int[] res = countsort(arr);
    System.out.println(Arrays.toString(res));
    
  }

  static int[] countsort(int[] arr) {
    int max = 0;
    for (int n : arr) {
      max = Math.max(max, n);
    }
    //used as freq as well as prefix  sum(cumulative)
    int[] count = new int[max + 1];
    for (int n : arr) {
      count[n]++;
    }
    //reise the freq as prefix sum array
    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i - 1];
    }
    //need to new array inorder to preserve order
    int[] res = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      //??
      res[count[arr[i]] - 1] = arr[i];
      count[arr[i]]--;
    }
    return res;
  }
}
