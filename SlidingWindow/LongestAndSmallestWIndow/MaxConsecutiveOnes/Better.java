package SlidingWindow.LongestAndSmallestWIndow.MaxConsecutiveOnes;

public class Better {
      public int longestOnes(int[] nums, int k) {
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
