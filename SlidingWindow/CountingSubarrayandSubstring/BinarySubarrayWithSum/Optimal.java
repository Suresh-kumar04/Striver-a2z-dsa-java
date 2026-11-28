package SlidingWindow.CountingSubarrayandSubstring.BinarySubarrayWithSum;

public class Optimal {
      public int numSubarraysWithSum(int[] nums, int goal) {
//         atMost(goal)      = [sum 0] + [sum 1] + ... + [sum goal-1] + [sum goal]
//      -  atMost(goal - 1)  = [sum 0] + [sum 1] + ... + [sum goal-1]
//                     ------------------------------------------------
//         difference        =                                          [sum goal]
       return atMost(nums , goal) - atMost(nums , goal-1);
    }
    int atMost(int[] nums , int goal){
        //case when goal - 1 is < 0
        if(goal < 0) return 0;
        int sum=0,l=0,r=0,subarray =0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l++];
            }
            subarray += r-l+1;
            r++;
        }
        return subarray;
    }
}

