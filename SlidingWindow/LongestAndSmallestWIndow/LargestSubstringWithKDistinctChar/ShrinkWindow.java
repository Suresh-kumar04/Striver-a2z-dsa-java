package SlidingWindow.LongestAndSmallestWIndow.LargestSubstringWithKDistinctChar;

public class ShrinkWindow {
    //Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.

      public int kDistinctChar(String s, int k) {
       int[] seen = new int[26];
       int l=0,max=0, dist =0;
       for(int r=0;r < s.length();r++){
            int ch = s.charAt(r)-'a';
            seen[ch]++;
            if(seen[ch] == 1){// first time seeing
                dist++;
            }
            while(dist > k){//shrink window till valid again
                int left = s.charAt(l)-'a';
                seen[left]--;
                if(seen[left] == 0) dist--;
                l++;
            }
            max = Math.max(max,r-l+1);
       }
       return max;
    }
}
