package Arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class better {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // treeset couldnt work list it could sort every list , not elements inside
        HashSet<List<Integer>> sorted = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // could use arraylist but its not o(1)
            Set<Integer> st = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                // nums[i] + nums[j] + nums[k] =0 =
                // nums[k] = -(nums[i] + nums[j])
                int third = -(nums[i] + nums[j]);
                if (st.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet);
                    sorted.add(triplet);
                }
                st.add(nums[j]);
            }
        }
        // <> means infer from return type !!!
        return new ArrayList<>(sorted);
    }
}
