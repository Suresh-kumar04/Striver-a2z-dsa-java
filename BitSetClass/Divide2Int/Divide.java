package BitSetClass.Divide2Int;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == divisor) return 1;

        boolean isPositive = true;
        if (dividend < 0 && divisor > 0) isPositive = false;
        if (divisor < 0 && dividend > 0) isPositive = false;

        long remaining = Math.abs((long) dividend);//remaining of dividend after subtracting from divisor*2^absolute divisor

        long absDivisor = Math.abs((long) divisor);   

        int quotient = 0;                             

        while (remaining >= absDivisor) {
            int shift = 0;   
                        //divisor * 2 ^ shift+1                        
            while ((absDivisor << (shift + 1)) <= remaining) {
                shift++; 
            }
            quotient += 1 << shift;//2^shift <= dividened so add
            remaining -= absDivisor << shift;
        }
        return isPositive ? quotient : -quotient;
    }
}
