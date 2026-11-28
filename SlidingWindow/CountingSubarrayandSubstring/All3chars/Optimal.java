package SlidingWindow.CountingSubarrayandSubstring.All3chars;

public class Optimal {
    // Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.
      public int numberOfSubstrings(String s) {
        int[] lastSeenIdx = {-1,-1,-1};
        int cnt =0;
        for(int i=0;i<s.length();i++){
            lastSeenIdx[s.charAt(i)-'a']=i;
            cnt += 1 + Math.min(lastSeenIdx[0] , Math.min(lastSeenIdx[1] , lastSeenIdx[2]));
            //+1 handels -1 case too
        }
        return cnt;
    }
}
