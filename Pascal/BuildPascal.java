package StriverDsa.Pascal;

import java.util.ArrayList;
import java.util.List;

public class BuildPascal {
    public static void main(String[] args) {
         List<List<Integer>>  res = pascalTriangleIII(5);
         System.out.println(res);
    }
    public  static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        for(int i=1;i<n ;i++){
            List<Integer> next = new ArrayList<>();
            List<Integer> prev = res.get(i-1);
            next.add(1);
            for(int j=1;j<prev.size();j++ ){
                next.add( prev.get(j) + prev.get(j-1));
            }
            next.add(1);
            res.add(next);

        }
        return res;

    }
}
