package BitSetClass.Divide2Int.Divide;

public class Optimized {
    //O(log n)
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isPositive = (dividend < 0) == (divisor < 0);

        long remaining = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;
        //start from last bit cuz trying to find largest multiple 1st
        for(int shift = 31 ; shift >=0;shift--){
            if((absDivisor << shift) <= remaining){
                remaining -= absDivisor<<shift;
                quotient |= (1<<shift);//build bit by bit. same as quotient += 
            }
        }
        return isPositive?quotient:-quotient;
}
}
