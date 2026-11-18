package BitSetClass.SetBit;
//         You are given a positive integer n.

// Your task is to set the rightmost unset bit (0 bit) in the binary representation of n.

// Setting a bit means changing it from 0 to 1. Return the resulting integer after performing the operation.

public class SetRightmostUnsetBit {
      public int setRightmostUnsetBit(int n) {
    
        int mask = 1;
        //find 1st zeroth bit
        while ((n & mask) != 0) {
            mask <<= 1;
        }
        //make it 1
        n |= mask;
        return n;
    }
}
