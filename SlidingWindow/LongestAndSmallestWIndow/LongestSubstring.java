package SlidingWindow.LongestAndSmallestWIndow;

import java.util.Arrays;

public class LongestSubstring {
    //longest substring without duplicates
      public int lengthOfLongestSubstring(String s) {
      int[] seen = new int[128];
      Arrays.fill(seen , -1);// -1 means never seen and handles 0th index case for seen[s.charAt(r)] +1
      int max =0,left =0;
      for(int r=0;r<s.length();r++){
        left = Math.max(seen[s.charAt(r)] +1,left);//jump last occurrence, never backwards 
        max = Math.max(max , r - left +1);
        seen[s.charAt(r)] = r;
      }
      return max;
    }
}
