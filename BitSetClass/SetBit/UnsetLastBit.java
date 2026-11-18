package BitSetClass.SetBit;

public class UnsetLastBit {
    public int unsetBit(int n){
        return n & (n-1);
    }
}
