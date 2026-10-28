package BinarySearch.BinarySearchOnAns;

public class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }
     public static int findKthPositive(int[] arr, int k) {
       int s=0,e=arr.length-1;
       while(s <= e){
        int mid = (s+e)/2;
        int missing = arr[mid] - (mid+1);
        if(missing < k){
            s = mid+1;
        }else{
            e = mid-1;
        }
       }
        // After the loop: e = last index with missing < k (lower bound)
        //                 s = e + 1 = first index with missing >= k (upper bound)
        // The answer lies in the value range between arr[e] and arr[s].
        // Start at the value arr[e], then walk the remaining missing numbers:
        //   remaining = k - missing(e) = k - (arr[e] - (e+1))
        //   answer    = arr[e] + remaining

            // answer = arr[e] + k - (arr[e] - (e+1))
            //        = k + e + 1      // arr[e] cancels
            //        = k + s          // since s = e + 1
        // If e == -1 (nothing before the answer), answer = k.
       return k + e +1; // or return k + s; since s = e + 1
    }
}
