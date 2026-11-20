package BitSetClass.Divide2Int;

public class WithoutLong {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean isPositive = (dividend<0) == (divisor<0);

        //force both to be negative to avoid overflow caused by Math.abs
        int remaining = dividend > 0 ? -dividend : dividend;
        int negDivisor = divisor >0 ? -divisor : divisor;

        int quotient =0;
        for (int expo = 31; expo >=0; expo--) {
            if(negDivisor >= (Integer.MIN_VALUE >>expo) && (negDivisor << expo) >= remaining){
                quotient += -1<<expo;
                remaining -= negDivisor <<expo;
            }
        }
        return  isPositive ? -quotient : quotient;
    }
}
