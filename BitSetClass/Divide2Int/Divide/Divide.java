package BitSetClass.Divide2Int.Divide;

public class Divide {
    public int divide(int dividend, int divisor) {
        //O(log^2n)
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == divisor) return 1;

        boolean isPositive = true;
        if (dividend < 0 && divisor > 0) isPositive = false;
        if (divisor < 0 && dividend > 0) isPositive = false;
        //need long cuz abs of 2^31 will  overflow
        long remaining = Math.abs((long) dividend);//remaining of dividend after subtracting from divisor*2^absolute divisor

        long absDivisor = Math.abs((long) divisor);   

        int quotient = 0;                             
        //logn
        while (remaining >= absDivisor) {
            int shift = 0;   
                        //divisor * 2 ^ shift+1    
                        //logn                    
            while ((absDivisor << (shift + 1)) <= remaining) {
                shift++; 
            }
            quotient += 1 << shift;//2^shift <= dividened so add
            remaining -= absDivisor << shift;
        }
        return isPositive ? quotient : -quotient;
    }
}
