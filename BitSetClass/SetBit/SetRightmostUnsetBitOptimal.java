package BitSetClass.SetBit;

public class SetRightmostUnsetBitOptimal {
    public int setRightmostUnsetBit(int n){
        //n+1 sets n's first 0 (right most 1st) to 1 and remaining to the right to 0
        // n       = 1 0 1 1 1
        // n + 1   = 1 1 0 0 0
        if((n& n+1) ==0) return n;//case for all ones (eg: 7 = 111)
        //0 | 1 = 1
        return n | (n+1);
    }
}
