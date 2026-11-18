package BitSetClass.HammingWeight;

public class BrianKernighan {
    public int hammingWeight(int n) {
        int cnt =0;
        while(n!=0){
            // subtracting 1 flips the lowest set bit to 0 and turns the zeros below it into 1s.
            //  ANDing with the original clears exactly that one bit
            n =n & (n-1);
            cnt++;
        }
        return cnt;
    }
}
