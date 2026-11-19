package BitSetClass.MinBitFlips;

public class brute {
      public int minBitFlips(int n, int goal) {
        int cnt = 0;
        int mask = 1;
        //O(31)
        while (mask != 0) {                          // mask becomes 0 after shifting past bit 31
            if ((n & mask) != (goal & mask)) cnt++;  // compare the same bit in both numbers
            mask <<= 1;
        }
        return cnt;
    }   
}
