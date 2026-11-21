package BitSetClass.XorInRange;

public class OneToN {
    public int findRangeXOR(int n) {
        return  switch(n%4){
            case 1 -> 1;
            case 2 -> n+1;
            case 3 -> 0;
            default  -> n;
        };
    }
}
