package BitSetClass;

public class IsPowOf2 {
     public boolean isPowerOfTwo(int n) {
        return n<=0?false:(n& (n-1)) ==0;
    }
}
