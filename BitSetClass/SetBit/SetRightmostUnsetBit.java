package BitSetClass.SetBit;
//         You are given a positive integer n.

// Your task is to set the rightmost unset bit (0 bit) in the binary representation of n.

// Setting a bit means changing it from 0 to 1. Return the resulting integer after performing the operation.

public class SetRightmostUnsetBit {

    public int setRightmostUnsetBit(int n) {
        int mask = 1;
        while (mask <= n) {
            if ((n & mask) == 0) return n | mask;
            mask <<= 1;
        }
        //for special case where all bits are 1 (eg : 7=111)
        return n;
    }
    
}
