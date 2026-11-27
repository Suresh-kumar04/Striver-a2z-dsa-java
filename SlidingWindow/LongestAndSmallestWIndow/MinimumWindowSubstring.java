package SlidingWindow.LongestAndSmallestWIndow;

public class MinimumWindowSubstring {
    // Given two strings s and t, return the minimum window substring of s such that
    // every character in t (including duplicates) is included. Otherwise return "".

    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {      
            freq[c]++;
        }
        // freq[c] > 0  -> window still needs c
        // freq[c] == 0 -> window has exactly enough
        // freq[c] < 0  -> surplus (extra copies, or chars not in t)
        int l = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (freq[ch] > 0) count--;        // only a needed char reduces count
            freq[ch]--;

            while (count == 0) {              // window valid, so shrink as far as possible
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    minStart = l;
                }
                char left = s.charAt(l);
                freq[left]++;
                if (freq[left] > 0) count++;  // removed a needed char, so window is invalid
                l++;                          // while becomes flase.then expand r to find that char again
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}