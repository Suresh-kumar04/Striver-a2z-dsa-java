package Recursion.SubSetSum;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum1 {
    public static void main(String[] args) {
        int[] nums = {5,2,1};
        List<Integer> res =  subsetSums(nums);
        System.out.println(res);
    }
    
    public static List<Integer> subsetSums(int[] nums) {
       List<Integer> res = new ArrayList<>();
       helper(res , 0,nums,0);
       return res;
    }

     private static void helper(List<Integer> res , int i , int[] nums ,int sum){
        if(i == nums.length){
            res.add(sum);
            return ;
        } 
        helper(res , i+1 , nums , sum);
        helper(res , i+1 , nums , sum + nums[i]);

    }
}
