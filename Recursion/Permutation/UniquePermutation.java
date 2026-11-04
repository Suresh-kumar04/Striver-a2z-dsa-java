package Recursion.Permutation;

import java.util.*;;

public class UniquePermutation {
    public static void main(String[] args) {
        Set<List<Integer>> res = new HashSet<>();
        int[] nums ={1,1,1};
        uniquepermutate(res, new ArrayList<>(), 0, nums);
        System.out.println(res);
    }
    static void uniquepermutate(Set<List<Integer>>res ,List<Integer> curr , int i,int[] nums){
        if(i == nums.length){
            for(int j=0;j<nums.length;j++){
                curr.add(nums[j]);
            }
            res.add(new ArrayList<>(curr));
            curr.clear();
            return ;
        }
        Set<Integer> st = new HashSet<>();
        for(int low =i ; low < nums.length;low++){
            if(!st.add(nums[low])) continue;
            swap(nums , i , low);
            uniquepermutate(res, curr, i+1, nums);
            swap(nums, i, low);
        }
    }
    private static  void swap(int[] nums , int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
