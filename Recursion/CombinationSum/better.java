package Recursion.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class better {
   //Time = O(n · C(n+T, T)) + O(T · C(n+T, T)) = O( (n+T) · C(n+T, T) )
// Space = recursion depth (≤ n + T + 1) + curr (≤ T) = O(n + T)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res , new ArrayList<>(),candidates ,0 , target );
        return res;

    }
    void helper(List<List<Integer>> res , List<Integer> curr , int[] nums , int i , int target){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target <0 || i == nums.length) return;
        curr.add(nums[i]);
        //we are not incrementing i because we can use the same number again and again
        helper(res , curr , nums , i, target -nums[i]);
        curr.remove(curr.size()-1);
        helper(res , curr , nums , i+1 , target );
    }
}
