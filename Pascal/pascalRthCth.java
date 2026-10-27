package StriverDsa.Pascal;

public class pascalRthCth {
    public static void main(String[] args) {
        // Given two integers r and c, return the value at the rth row and cth column (1-indexed) in a Pascal's Triangle.
        int r=10,c=3;
        System.out.println(nCr(r-1, c-1));

    }
    static  long nCr(int n , int r){
        long res=1;
        r = Math.min(r, n-r);
        for (int i = 0; i < r; i++) {
            res *= n-i;//can writee Math.multiplyExact
            res/=i+1;

        }
        return res;
    }
}
