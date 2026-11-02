package String.LongestSubstring;

public class Optimal {
    public String longestPalindrome(String s) {
    String res ="";
    int n=s.length();
    for(int i=0;i<n;i++){
        //for odd len
        int st =i , e = i;
        while(st >=0 && e <n && s.charAt(st) == s.charAt(e) ){
            st--;
            e++;
        }
        if((e - st -1) > res.length()) res = s.substring(st +1, e);

        //for even 
        st =i;e =i+1;
        while(st >=0 && e <n && s.charAt(st) == s.charAt(e)){
            st--;
            e++;
        }
          if((e - st -1) > res.length()) res = s.substring(st +1, e);

    }
    return res;
}
}
