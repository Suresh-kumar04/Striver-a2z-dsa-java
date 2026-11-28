package SlidingWindow.CountingSubarrayandSubstring.All3chars;
// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.


public class Brute {
    //TLE
    public int numberOfSubstrings(String s) {
        int cnt =0;
        for(int i=0;i<s.length();i++){
            int[] seen = {0,0,0};
            for(int j = i;j<s.length();j++){
             seen[s.charAt(j)-'a']++;
             if(seen[0] > 0 && seen[1]>0 && seen[2]>0 ){
                cnt++;
             }
            }
        }
        return cnt;
    }
}
