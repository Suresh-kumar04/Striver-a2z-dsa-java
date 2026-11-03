package Recursion.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubSets {
  //O(n*2^n)
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li = Arrays.asList(1,2,3,4);
        subsets(li, res, 0,new ArrayList<>());
        System.out.println(res);

    
    }
    static void subsets(List<Integer> li , List<List<Integer>> res,int i , List<Integer> curr){
      if(i == li.size()){
        res.add(new ArrayList<>(curr));
        return ;
      }
      curr.add(li.get(i));

      subsets(li, res, i+1, curr);
      curr.remove(curr.size()-1);
      subsets(li, res, i+1, curr);
    }

    
}
