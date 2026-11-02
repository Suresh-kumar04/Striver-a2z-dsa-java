package String.LongestSubstring;

public class brute {
    public String longestPalindrome(String s) {
        String res = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s , i , j)){
                    if(j-i +1 > res.length()){
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    boolean isPalindrome(String s , int l ,int r){
        
        while(l <r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
