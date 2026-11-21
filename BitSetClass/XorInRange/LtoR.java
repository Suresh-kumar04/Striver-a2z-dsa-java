package BitSetClass.XorInRange;

public class LtoR {
    public int findRangeXOR(int l, int r) {
        //numbers between 1-l and r-1 will be canceled out since x^x =0 then xor l to r
        //1 to l                      1 to r 
        return findRangeXOR(l-1) ^ findRangeXOR(r);
    }
     public int findRangeXOR(int n) {
        return  switch(n%4){
            case 1 -> 1;
            case 2 -> n+1;
            case 3 -> 0;
            default  -> n;
        };
    }
}
