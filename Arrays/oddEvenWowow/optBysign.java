package Arrays.oddEvenWowow;

import java.util.Arrays;

public class optBysign {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, -1, -3, -4 };
        int res[] = rearrange(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }

    public static int[] rearrange(int[] nums) {
        int posPos = 0;
        int negPos = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                res[negPos] = nums[i];
                negPos += 2;
            } else {
                res[posPos] = nums[i];
                posPos += 2;
            }
        }
        return res;
    }
}
