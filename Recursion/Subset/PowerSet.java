package Recursion.Subset;
import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        int totalSubsets = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int index = 0; index < nums.length; index++) {
                if ((mask & (1 << index)) != 0) {
                    subset.add(nums[index]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
