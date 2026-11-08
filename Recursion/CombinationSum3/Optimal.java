package Recursion.CombinationSum3;

import java.util.ArrayList;
import java.util.List;

public class Optimal {
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> curr, int k, int target, int start) {
        if (k == 0) {
            if (target == 0) res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = start; j <= 10 - k; j++) {   // makes sure we have enough numbers left to pick k numbers i.e if we have 3 numbers left to pick(k=3) then we need to have at least 3 numbers left to pick from so j <= 10 - k
            
            if (j > target) break;                // sorted ascending, so larger j only gets worse
            curr.add(j);
            helper(res, curr, k - 1, target - j, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
