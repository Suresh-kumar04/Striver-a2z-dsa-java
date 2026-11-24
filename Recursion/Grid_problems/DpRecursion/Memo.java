package Recursion.Grid_problems.DpRecursion;

public class Memo {
     public boolean checkValidString(String s) {
        //O(n^2) , O(n^2)
        Boolean[][] memo = new Boolean[s.length()+1][s.length()+1];
        return dp(s, 0, 0,memo);
    }
    static boolean dp(String s , int cnt ,  int i , Boolean[][] memo){
        // cnt greater than remaining elements , hence impossible to make it 0
        if(cnt > s.length() -i || cnt < 0 ) return false;
        if(i == s.length()){
            return cnt == 0;
        }
        if(memo[i][cnt] != null) return  memo[i][cnt];

        if(s.charAt(i) == '('){
           return  memo[i][cnt] = dp(s, cnt + 1, i+1,memo);

        }else if(s.charAt(i) == ')'){
            return memo[i][cnt] = dp(s, cnt-1, i+1,memo);

        }
        else
        return memo[i][cnt] = dp(s, cnt, i+1,memo) || dp(s, cnt+1, i+1,memo) || dp(s, cnt-1, i+1,memo);

    }
}
