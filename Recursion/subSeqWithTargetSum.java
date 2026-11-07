package Recursion;

public class subSeqWithTargetSum {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return helper(nums, k, 0, 0);
    }
    int helper(int[] nums, int k, int curr, int i) {
        if (i == nums.length) return curr == k ? 1 : 0;
        return helper(nums, k, curr + nums[i], i + 1)
             + helper(nums, k, curr, i + 1);
    }
}
