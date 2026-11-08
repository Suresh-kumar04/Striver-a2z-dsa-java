package Recursion.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class optimal {
    //O(n*2^n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res , new ArrayList<>(),candidates ,0 , target );
        return res;

    }
    void helper(List<List<Integer>> res , List<Integer> curr , int[] nums , int start , int remain ){
        if(remain == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j=start;j<nums.length;j++){
            if(nums[j] > remain) return;
            curr.add(nums[j]);
            helper(res , curr , nums , j , remain - nums[j]);
            curr.remove(curr.size()-1);
        }


    }
}
