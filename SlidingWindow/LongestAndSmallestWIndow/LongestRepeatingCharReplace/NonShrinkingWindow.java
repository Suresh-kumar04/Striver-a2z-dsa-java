package SlidingWindow.LongestAndSmallestWIndow.LongestRepeatingCharReplace;

public class NonShrinkingWindow {
      public int characterReplacement(String s, int k) {
        //You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

        // Return the length of the longest substring containing the same letter you can get after performing the above operations.
        int l=0,maxFreq=0;
        int[] freq = new int[26];
        for(int r=0;r<s.length();r++){
            int ch = s.charAt(r)-'A';
            freq[ch]++;
            maxFreq = Math.max(maxFreq , freq[ch]);  
            if(r-l +1 - maxFreq > k){
                freq[s.charAt(l++)-'A']--;
            }  
        }
        return s.length() - l;
    }
}
