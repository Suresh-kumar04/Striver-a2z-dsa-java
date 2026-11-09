package Recursion.PalindromPartisioning;

import java.util.ArrayList;
import java.util.List;

public class Memo {


    public List<List<String>> partition(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i = s.length()-1;i>=0;i--){
            for (int j=i; j < s.length(); j++) {
                isPal[i][j] = s.charAt(i)==s.charAt(j) && (j-i < 2 || isPal[i+1][j-1]); 
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res,isPal);
        return res;
    }

    private void backtrack(String s, int start, ArrayList<String> curr, List<List<String>> res , boolean[][] pal) {
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return ;
        }
        for (int end = start; end < s.length(); end++) {
            if(pal[start][end]){
                curr.add(s.substring(end, end+1));
                backtrack(s, end+1, curr, res, pal);
                curr.remove(curr.size()-1);
            }
        }
    }
}
