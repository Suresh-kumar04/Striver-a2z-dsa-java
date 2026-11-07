package Recursion;

import java.util.Arrays;
public class NumberofSequence {
    final static  int mod = (int)1e9+7;
//     You are given an array of integers nums and an integer target.

// Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.
     public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, n = nums.length , r = n-1 , res =0;
        int pow[] = new int[n];
        pow[0] =1;
        for(int i=1;i<n;i++) pow[i] = pow[i-1] * 2 % mod;
        while(l <=r){
            if(nums[l] + nums[r] <= target){
                res = (res+ pow[r-l] )% mod; 
                l++;
            }else{
                r--;
            }
        }
        return res;

    }
}
