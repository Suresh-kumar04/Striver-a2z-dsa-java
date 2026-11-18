package BitSetClass.SetBit;

public class SetIthBitSet {
   public  int setIthBitSet(int n , int i){
        n = n | 1<<i;
        return  n;
    }
}
