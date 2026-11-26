package SlidingWindow.LongestAndSmallestWIndow.MaxConsecutiveOnes;

public class Optimal {
    //O(n) , window doesnt shrink
    public int longestOnes(int[] nums, int k) {
        int l=0 ;
        for(int r =0 ; r < nums.length;r++){
            if(nums[r] == 0) k--;
            if(k < 0 ){
                if(nums[l] == 0){
                    k++; // give the flip back
                }
                l++;// keep moving with max valid window found
            }
        }
        return nums.length - l;
    }
}

