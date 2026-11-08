package Recursion.Subset2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class better {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res , new ArrayList<>() , nums , 0);
        return res;

    }
    void helper(List<List<Integer>> res , List<Integer> curr ,int[] nums , int i){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(res , curr , nums , i+1);
        curr.remove(curr.size()-1);

        int j = i;
        while(j + 1< nums.length && nums[j] == nums[j+1]){
            i++;
            j++;
        }
        helper(res , curr , nums , i+1);
    }
}
