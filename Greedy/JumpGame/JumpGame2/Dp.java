package Greedy.JumpGame.JumpGame2;

public class Dp {
    public int jump(int[] nums){
        //mle , O(N^2)
        int[][] memo = new int[nums.length][nums.length];
        return dp(nums,0, memo, 0);
    }
    int dp(int[] nums ,int jumps, int[][] memo , int idx){
        if(idx >= nums.length-1) return  jumps;
        if(memo[idx][jumps] != 0) return memo[idx][jumps];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            min = Math.max(min, dp(nums, jumps+1, memo, idx+i));
        }
       return memo[idx][jumps] = min;

    }
}
