package Arrays.oddEvenWowow;

import java.util.Arrays;

public class bySign {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, -1, -3, -4 };
        int[] res = rearrangeArray(arr);
        IO.print(Arrays.toString(res));

    }

    public static int[] rearrangeArray(int[] nums) {
        int l = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            int pos = 0, neg = 0;
            int j = 0;
            while (j < nums.length) {
                if (nums[j] > 0) {
                    pos = nums[j];
                    nums[j] = 0;
                    break;
                }
                j++;
            }

            j = 0;
            while (j < nums.length) {
                if (nums[j] < 0 && nums[j] != 0) {
                    neg = nums[j];
                    nums[j] = 0;
                    break;
                }
                j++;
            }

            res[l++] = pos;
            res[l++] = neg;

        }
        return res;
    }
}