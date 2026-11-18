package BitSetClass;

import java.util.Arrays;

public class Swap2Nums {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        swap(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
    }
    static void swap(int[] nums, int a , int b){
        if (a==b) {
            return ;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
