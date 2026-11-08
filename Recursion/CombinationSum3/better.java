package Recursion.CombinationSum3;

import java.util.ArrayList;
import java.util.List;

public class better {
    public static void main(String[] args) {
        better b = new better();
        List<List<Integer>> res = b.combinationSum3(3, 8);
        System.out.println(res);
    }
      public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res , new ArrayList<>(),k , n , 9);
        return res;
    }
    void helper(List<List<Integer>> res , List<Integer> curr , 
    int k , int target , int num){
        if(k== 0 ){
            if(0 == target){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
                     //num < k is better than num <=0 because if num < k then we can't pick k numbers from num numbers
                     //if we have 3 numbers(num=3) and we need to pick 4 numbers(k=4) then we can't pick 4 numbers from 3 numbers so we can return
        if(target < 0 || num < k)  return;
        curr.add(num);
        helper(res , curr , k-1 , target - num , num-1);
        curr.remove(curr.size()-1);
        helper(res , curr , k , target , num-1);

    }
}
