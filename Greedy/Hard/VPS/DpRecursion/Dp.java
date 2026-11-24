package Greedy.Hard.VPS.DpRecursion;

public class Dp {
    public boolean checkValidString(String s) {
        //O(3^n) TLE
        return dp(s, 0, 0);
    }
    static boolean dp(String s , int cnt ,  int i){
        if(cnt < 0 ) return  false;
        if(i == s.length()){
            return cnt == 0;
        }
        if(s.charAt(i) == '('){
           return  dp(s, cnt + 1, i+1);
        }else if(s.charAt(i) == ')'){
            return dp(s, cnt-1, i+1);
        }
        else
        return dp(s, cnt, i+1) || dp(s, cnt+1, i+1) || dp(s, cnt-1, i+1);
    }
}
