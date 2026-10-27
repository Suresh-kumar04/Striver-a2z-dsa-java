package Arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0)
                break; // no way to reach 0 from here
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // skip duplicate first number

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++; // skip duplicate second
                    while (j < k && nums[k] == nums[k + 1])
                        k--; // skip duplicate third
                }
            }
        }
        return res;
    }
}
