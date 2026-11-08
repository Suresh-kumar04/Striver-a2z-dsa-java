package Recursion.Subset2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class optimal {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        res = new optimal().subsetsWithDup(nums);
        System.out.println(res);
    }
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res , new ArrayList<>() , nums , 0);
        return res;

    }
    void helper(List<List<Integer>> res , List<Integer> curr ,int[] nums , int i){
        //no base case because of the for loop, we will add the current list to the result and then iterate through the rest of the elements
            res.add(new ArrayList<>(curr));
        
        for(int j = i ; j< nums.length;j++){
            if(j>i && nums[j] == nums[j-1]) continue;
            curr.add(nums[j]);
            helper(res,curr,nums ,j+1 );
            curr.remove(curr.size()-1);
            //no function call for not take because we are iterating through the rest of the elements in the for loop, so we don't need to make a function call for not taking the current element
        }
    }
}
