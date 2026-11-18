package BitSetClass.ClearIthBit;

public class ClearIthBit {
    public int clearIthBit(int n , int i){
        return n & ~(1<<i);
    }
}
