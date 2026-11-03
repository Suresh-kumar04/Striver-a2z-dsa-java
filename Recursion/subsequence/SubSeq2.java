package Recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

public class SubSeq2 {
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        String str = "abc";
        subseq2(str, res, new ArrayList<>(), 0);
        System.out.println(res);

    }
    static  void subseq2(String li, List<List<String>> res, List<String> curr,int i){
        if(i == li.length()){
            res.add(new ArrayList<>(curr));
            return ;
        }
        curr.add(li.substring(i,i+1));
        subseq2(li, res, curr, i+1);
        curr.remove(curr.size()-1);
        subseq2(li, res, curr, i+1);


    }
}
