package Recursion.Permutation.UniquePermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizedUnique {
    public static void main(String[] args) {
        int[] nums ={1,1,2};
        OptimizedUnique obj = new OptimizedUnique();
        List<List<Integer>> res = obj.permuteUnique(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permutate(nums , res ,new ArrayList<>(),new boolean[nums.length]);
        return res;

    }
    void permutate(int[]  nums , List<List<Integer>>res,List<Integer> curr,boolean[]  seen){
        if(curr.size() == nums.length){
           res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i < nums.length;i++){
                                                        // why we are checking this condition because if the current number is same as previous number and previous number is not used in the current permutation then we will skip the current number to avoid duplicate permutations
            if(seen[i] || (i> 0 && nums[i] == nums[i-1] && !seen[i-1])) continue;
            seen[i] = true;
            curr.add(nums[i]);
            permutate(nums , res , curr , seen);
            curr.remove(curr.size()-1);
            seen[i] = false;
        }
    }
   

}
