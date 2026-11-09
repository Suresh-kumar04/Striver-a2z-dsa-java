package Recursion.PalindromPartisioning;

import java.util.ArrayList;
import java.util.List;

public class BackTrack {

    public static void main(String[] args) {
        BackTrack pp = new BackTrack();
        System.out.println(pp.partition("aabbaa"));
    }

   public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    backtrack(s, 0, 0, new ArrayList<>(), res);
    return res;
}

// idx   = s's index
// start = where the current (unfinished) piece began
void backtrack(String s, int idx, int start, List<String> curr, List<List<String>> res) {
    if (idx == s.length()) {
        if (start == s.length()) res.add(new ArrayList<>(curr)); // last piece was closed
        return;
    }
    if(isPal(s, start, idx)){
        curr.add(s.substring(start , idx+1));
        backtrack(s, idx+1, idx+1, curr, res);
        curr.remove(curr.size()-1);
    }

    backtrack(s, idx+1, start, curr, res);

}

boolean isPal(String s, int l, int r) {
    while (l < r) {
        if (s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
}
}
