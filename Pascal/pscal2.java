package StriverDsa.Pascal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pscal2 {
    public static void main(String[] args) {
        //print nth row of pascal triangle
        int[] res = pascalTriangleII(2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] pascalTriangleII(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long val = 1;
        int n = rowIndex - 1; // 1-indexed -> 0-indexed
        for (int r = 1; r <= n; r++) {
            val = val * (n - r + 1) / r; // use n, not rowIndex
            res.add((int) val);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
