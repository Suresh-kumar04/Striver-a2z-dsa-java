package SlidingWindow.LongestAndSmallestWIndow.LongestRepeatingCharReplace;

public class Shrinkingwindow {
      public int characterReplacement(String s, int k) {
        int l=0,max=0,maxFreq=0;
        int[] freq = new int[26];
        for(int r=0;r<s.length();r++){
            int ch = s.charAt(r)-'A';
            freq[ch]++;
            maxFreq = Math.max(maxFreq , freq[ch]);

            while((r-l+1) - maxFreq >k){ // means remaining of all other than max element cuz we need to convert those to max element
                int left =  s.charAt(l) -'A';
                freq[left]--;
                l++;
            }
            max = Math.max(max , r-l+1);
        }
        return max;
    }
}
