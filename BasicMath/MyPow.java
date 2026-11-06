package BasicMath;
public class MyPow {
    public static void main(String[] args) {
        
    }
     public double myPow(double x, int expo) {
        //long because expo can be -2^31 and 2^31 is out of range of int(max  is 2^31-1)
        long n = expo;
        //if n^-ve then
        //step 1 : make it +ve
        //step 2 : calculate the power
        //example : 2^-3 = 1/(2^3) = 1/8
        if(n <0){
            n = -n;
        }
        // x^n = (x*x)^n/2 if n is even
        // x^n = x*(x*x)^n/2 if n is odd
        //example : 2^10 can be written 9as
                //2^10 = (2^5)(2^5)

                // 2^5 = (2^2)(2^2) x 2

                // 2^2 = (2^1)(2^1)

                // 2^1 = (2^0)(2^0) x 2

                // 2^0 = 1
        double ans =1.0;
        while(n >0){
        
            if(n % 2 ==1){
                ans *= x;
            }
            x *= x;
            n/=2;
        }
        return expo<0 ? 1/ans  : ans;
    }
}
