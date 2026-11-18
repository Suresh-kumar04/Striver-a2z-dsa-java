package BitSetClass.HammingWeight;

public class HammingWeight {
     public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }
}
