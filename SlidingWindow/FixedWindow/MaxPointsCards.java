package SlidingWindow.FixedWindow;

public class MaxPointsCards {
    public static void main(String[] args) {
        int ans =maxScore(new int[]{1,2,44,1,5}, 2);
        IO.print(ans);
    }
     static  public int maxScore(int[] nums, int k) {
      int sum =0 , maxSum=0,r=nums.length-1;
      for(int i=0;i<k;i++){
        sum += nums[i];
      }
      maxSum = sum;
      
      for(int l = k-1;l>=0;l--){
        sum -= nums[l];
        sum += nums[r];
        r--;
        maxSum = Math.max(sum , maxSum);
      }
      return maxSum;
    }
}
