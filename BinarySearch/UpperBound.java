package StriverDsa.BinarySearch;

public class UpperBound {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 4, 5, 6, 8 };
        int x = 4;
        int index = upperBound(nums, x);
        System.out.println("Upper bound of " + x + " is at index: " + index);
    }
     public static int upperBound(int[] nums, int x) {
        int s=0;
        int n = nums.length;
        int ans = n;
        int e = n-1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(nums[mid] > x){
                ans = mid;
                e = mid-1;
          }else{
                s = mid+1;
            }
        }
        return ans;
    }
}


