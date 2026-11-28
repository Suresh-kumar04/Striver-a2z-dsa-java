package SlidingWindow.CountingSubarrayandSubstring.BinarySubarrayWithSum;

public class OddNum {

    public int numberOfSubarrays(int[] nums, int k) {
        //same as binary  , treat 0 as even and 1 as odd
      return atMost(nums , k) -  atMost(nums ,k-1);
    }
      int atMost(int[] nums , int goal){
        //case when goal - 1 is < 0
        if(goal < 0) return 0;
        int odds=0,l=0,r=0,subarray =0;
        while(r < nums.length){
            //odd gives 1 , even 0
            odds += nums[r] & 1;
            while(odds > goal){
                odds -= nums[l++] & 1;
            }
            subarray += r-l+1;
            r++;
        }
        return subarray;
    }
}
