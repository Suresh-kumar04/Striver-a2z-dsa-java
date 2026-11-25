package SlidingWindow.FixedWindow;

public class Fixedwindow {
    public static void main(String[] args) {
        int[] nums = {22,9999999,21,12,1};
        System.out.println(maxSum(nums, 2));

    }
    public static int maxSum(int[] nums , int k){

        int sum =0;
        //1st window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        int maxSum = sum;
        int l=0, r=k-1;

        while (r+1 < nums.length) {
            sum-=nums[l];
            l++;
            r++;
            sum+=nums[r];
            maxSum= Math.max(maxSum, sum);
        }
        return  maxSum;

    }
}
