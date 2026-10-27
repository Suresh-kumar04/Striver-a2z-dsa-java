package StriverDsa.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        
    }
    static  int[] nextPermutation(int[] arr){
        int n = arr.length;
        int pivot =-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse(arr, 0, n-1);
            return arr;
        }
        for(int i =n-1;i>pivot;i--){
            if(arr[i] > pivot){
                int t = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = t;
                break;
            }
        }
        reverse(arr, pivot+1, n-1);
        return arr;
    }
    static  void reverse(int[] arr,int i , int j){
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
