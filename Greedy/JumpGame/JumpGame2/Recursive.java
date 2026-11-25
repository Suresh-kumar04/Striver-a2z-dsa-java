package Greedy.JumpGame.JumpGame2;

public class Recursive {
    //O(n^n)
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        return recurse(nums, 0, 0);
    }
    static int recurse(int[] nums , int jumps , int idx){
        if(idx >= nums.length-1){
            return  jumps;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <=nums[idx]; i++) {
            min = Math.min(min,recurse(nums, jumps+1, idx + i));
        }
        return  min;
    }
}
