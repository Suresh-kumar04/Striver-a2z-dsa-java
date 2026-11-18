package BitSetClass.HammingWeight;

public class BrianKernighan {
    public int hammingWeight(int n) {
        int cnt =0;
        while(n!=0){
            // n - 1 flips the lowest set bit to 0 and turns all the zeros to its right into 1s.
            // n       = 1 0 1 0 0 =20
            // n - 1   = 1 0 0 1 1 =19
            //  ANDing with the original clears exactly that one bit
            n =n & (n-1);
            cnt++;
        }
        return cnt;
    }
}
