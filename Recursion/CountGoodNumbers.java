package Recursion;

public class CountGoodNumbers {
    static final int mod = (int)1e9+7;

    public int countGoodNumbers(long n) {
        long even = n-n/2;//ceil division
        long odd = n- even;
        return (int)(myPow(5, even) * myPow(4 , odd)%mod);

    }
    long myPow(long  x , long n){
        long res=1;
        while(n>0){
            if((n & 1) == 1){
                res =res *  x % mod;
            }
            x=x*x % mod;
            n>>>=1;
        }
        return res;
    }
}
