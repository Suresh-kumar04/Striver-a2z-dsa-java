package Greedy.JumpGame;
public class JumpGame1 {
    public boolean canJump(int[] nums) {
        int maxDist =0;
        for(int i=0;i<nums.length;i++){
            if(i > maxDist) return false;
            maxDist = Math.max(maxDist, nums[i] +i);
            if(maxDist >= nums.length-1) return true;
        }
        return true;
    }
}
