package SlidingWindow.LongestAndSmallestWIndow.MaxConsecutiveOnes;

public class Better {
    // Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

      public int longestOnes(int[] nums, int k) {
        //O(2n) , window shrinks ans resizes
        int l=0 , r = 0,len =0;
        while(r < nums.length){
            if(nums[r] ==0){
                k--;
            }
            while(k < 0){
                if(nums[l] == 0) k++;
                l++;
            }
            len = Math.max(len , r-l+1);
            r++;
        }
        return len;
    }
}
