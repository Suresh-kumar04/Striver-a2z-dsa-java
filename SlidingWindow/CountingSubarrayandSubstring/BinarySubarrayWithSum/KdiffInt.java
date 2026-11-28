package SlidingWindow.CountingSubarrayandSubstring.BinarySubarrayWithSum;

import java.util.Map;
import java.util.HashMap;
// Given an integer array nums and an integer k, return the number of good subarrays of nums.

// A good array is an array where the number of different integers in that array is exactly k.
public class KdiffInt {
//         atMost(goal)      = [sum 0] + [sum 1] + ... + [sum goal-1] + [sum goal]
//      -  atMost(goal - 1)  = [sum 0] + [sum 1] + ... + [sum goal-1]
//                     ------------------------------------------------
//         difference        =                                          [sum goal]

     public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k-1);
    }
    int atMost(int[] nums , int k){
        Map<Integer,Integer> map = new HashMap<>();
        int l =0,subarray=0;
        for(int r=0;r<nums.length;r++){
            map.merge(nums[r] , 1 , Integer::sum);
            while(map.size() > k){
                if(map.merge(nums[l] , -1 , Integer::sum) == 0){
                    map.remove(nums[l]);
                }   
                l++;
            }
            subarray += r-l+1;
        }
        return subarray;
    }
}
