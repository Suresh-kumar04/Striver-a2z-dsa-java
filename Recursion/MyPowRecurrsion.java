package Recursion;

public class MyPowRecurrsion {
    public static void main(String[] args) {
        System.out.println(myPow(9,11));
    }
    static double myPow(int x , int n){
        long e = n;
        double res =1;
        if(e<0){
            e=-e;
        }
        return e<0 ? 1/helper(x, e, res) : helper(x, e, res);

    }
     static double  helper (int x , long y , double curr){
        if(y <=0){
            return curr;
        }
        if((y&1) ==1) curr *=x;
        
       return helper(x*x, y>>>=1, curr);
    }
    
}
