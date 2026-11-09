package Recursion.PalindromPartisioning;

import java.util.ArrayList;
import java.util.List;

public class ForloopVersion {
    public static void main(String[] args) {
        ForloopVersion pp = new ForloopVersion();
        System.out.println(pp.partition("aabbaa"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s , res , new ArrayList<>() , 0);
        return res;
    }

    void backtrack(String s , List<List<String>> res , List<String> curr , int start){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
      for(int end=start ; end< s.length();end++){
        String sub = s.substring(start ,end+1);
        if(isPlai(sub)){
            curr.add(sub);
            backtrack(s , res , curr , end+1 );
            curr.remove(curr.size()-1);
        }
      }
    }
    
    boolean isPlai(String s){
        int l =0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

