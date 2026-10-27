import java.util.Arrays;

class mergesort {

  public static void main(String[] args) {

    int[] nums = { -99, 3, 0, 88, 4, 66, 8, 01, 1 };
    MergeSort(nums, 0, nums.length - 1);
    IO.print(Arrays.toString(nums));
  }

  static void MergeSort(int[] arr, int low, int high) {
    if (low >= high)
      return ;
    int mid = (low + high) / 2;
    MergeSort(arr, low, mid);
    MergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
    
  }

  static void merge(int[] arr, int left, int middle, int right) {
    int leftP = left;
    int rightP = middle + 1;
    int k = 0;
    int[] temp = new int[right - left + 1];
    while (leftP <= middle && rightP <= right) {
      if (arr[leftP] <= arr[rightP]) {
        temp[k++] = arr[leftP++];
      } else {
        temp[k++] = arr[rightP++];
      }
    }
    while (leftP <= middle) {
      temp[k++] = arr[leftP++];
    }

    while (rightP <= right) {
      temp[k++] = arr[rightP++];
    }
    for (int i = 0; i < temp.length; i++) {
      arr[left + i] = temp[i];
    }
  }
}
