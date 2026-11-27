package SlidingWindow.LongestAndSmallestWIndow.LargestSubstringWithKDistinctChar;

public class NonShrinkingWindow {
     public int kDistinctChar(String s, int k) {
        //move with max window , never shrink
       int[] seen = new int[26];
       int l=0, dist =0;
       for(int r=0;r < s.length();r++){
            int ch = s.charAt(r)-'a';
            if(seen[ch] == 0) dist++;//first time seeing
            seen[ch]++;
            if(dist > k){
                int left = s.charAt(l)-'a';
                seen[left]--;
                if(seen[left] == 0) dist--;
                l++;
            }
       }
       return s.length() - l;
    }
}
