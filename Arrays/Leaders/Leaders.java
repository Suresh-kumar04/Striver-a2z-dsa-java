package StriverDsa.Arrays.Leaders;

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    public static void main(String[] args) {
        int[] arr = {-3, 4, 5, 1, -4, -5};
        System.out.println(leaders(arr));

    }
    public static List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[i] >= nums[j]) {   // candidate nums[i] vs every element to its right
                j++;
            }
            if (j == n) {                            // reached the end, so nothing bigger was found
                list.add(nums[i]);
            }
            i++;
        }
        return list;
    }
}
