package SlidingWindow.LongestAndSmallestWIndow.MinimumWindowSubseq;

public class Optimal {
    public String minWindow(String s1, String s2) {
        int l=0;
        int m = s1.length(),n = s2.length();
        int minLen = Integer.MAX_VALUE,minStart =-1;

        int r =0;
        while (r < m) {
            //O(m * n)
            int j =0;
            //find end of valid subseq
            while (r < m) {
                if(s1.charAt(r) == s2.charAt(j))j++;
                if(j == n) break;
                r++;
            }
            if(r == m) break;

            //scan from back to find start of valid subseq (to minimize the window)
            int windowEnd = r ;
            j = n-1;
            while (j >=0) {
                if(s1.charAt(r) == s2.charAt(j))j--;
                r--;
            }
            int currWindowStart = r+1; //r ended one before the start
            if(windowEnd - currWindowStart +1 < minLen){
                minLen = windowEnd - currWindowStart+1;
                minStart = currWindowStart;
            } 
            //min window might be within the current window , t0 check that , we use +1
            r = currWindowStart +1;
        }
        if (minStart == -1) {
            return "";
        }
        return s1.substring(minStart, minStart + minLen);
    }
}
