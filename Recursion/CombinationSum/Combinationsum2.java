package Recursion.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combinationsum2 {
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //O(nlogn) for sorting and O(2^n) for recursion
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res , 0 , new ArrayList<>() ,candidates ,target);
        return res;
    }
    void helper(List<List<Integer>> res , int i , List<Integer> curr,int[] nums , int target){
        if(target ==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i == nums.length ||  target <  0) return;
        if(nums[i] > target) return;
        curr.add(nums[i]);
        helper(res , i+1 , curr , nums , target - nums[i]);
        curr.remove(curr.size() -1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(res , i+1 , curr , nums , target);

    }
    
}