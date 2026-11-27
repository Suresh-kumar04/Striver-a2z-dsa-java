package SlidingWindow.LongestAndSmallestWIndow.MinimumWindowSubseq;

public class Brute {
    // Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.

    // If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
    public String minWindow(String s1, String s2) {
        //O(m^2)
        int m = s1.length(),n = s2.length();
        int minLen = Integer.MAX_VALUE,minStart =-1;
        for(int start =0 ; start < m ; start++){
            int j =0;
            for(int i = start ; i < m ; i++){
                if(s1.charAt(i) == s2.charAt(j)) j++;
                if(j == n){
                    if(minLen > i - start +1 ){
                        minLen = i-start+1;
                        minStart = start;
                    }
                    break;
                }
            }
            if(j < n) break;
        }
        if(minStart ==-1) return "";
        return s1.substring(minStart , minStart + minLen);
    }
}
