package Recursion.Permutation;


import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> res = new java.util.ArrayList<>();
        int[] nums = {1,2,3};
        permute(nums, res, 0, new java.util.ArrayList<>()); 
        IO.print(res);
        
    }
    public static void permute(int[] nums , List<List<Integer>> res , int i,List<Integer> curr) {
        if(i == nums.length) {
           for(int j=0;j<nums.length;j++){
               curr.add(nums[j]);
           }
           //if we used res.add(curr) then it will give empty list because we are clearing the curr list after adding it to res, since res will store the reference of curr 
           //instead of the value of curr, we use new ArrayList<>(curr)  since it will create a snapshot of the curr list at that moment and store it in res 
           res.add(new java.util.ArrayList<>(curr));
           //clearing the curr list after adding it to res so that we can use it for the next permutation
           curr.clear();
           return;  
        }
        // low starts from i cuz before i elements are already fixed

        for(int low=i;low<nums.length;low++){
            swap(nums, i, low);
            permute(nums, res, i+1, curr);
        //backtrack is needed to restore the original array before the next iteration of the loop, so that we can generate all permutations
            swap(nums, i, low);
        }
       
    }
    private static void swap(int[] nums , int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] =t;
    }
}
