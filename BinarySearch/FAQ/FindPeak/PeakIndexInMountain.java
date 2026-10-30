package BinarySearch.FAQ.FindPeak;

public class PeakIndexInMountain {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int s =1,e=arr.length-2;
        while(s <=e){
            int mid = s+(e-s)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid] > arr[mid-1]){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return 0;
    }
}
