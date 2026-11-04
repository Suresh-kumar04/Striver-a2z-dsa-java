package Recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] nums ={1,2,3};
        List<List<Integer>> res =subsets(nums);
        System.out.println(res);


    }
     public static List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
        helper(res , new ArrayList<>() , 0 , nums);
        return res;
    }
    static void helper(List<List<Integer>> res , List<Integer> curr ,int i, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(res , curr , i+1 , nums);
        curr.remove(curr.size()-1);
        helper(res , curr , i+1 ,nums);
    }
}
