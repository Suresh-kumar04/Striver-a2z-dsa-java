package BitSetClass.SingleNumber;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int xor =0;
        for(int n : nums){
            xor ^= n;
        }
        //isolates first setbit and makes everythingelse 0

        int diffBit = xor & -xor;
        int ones =0,zeros =0;
        for(int n : nums){
            if((diffBit & n) !=0) ones ^= n;
            else zeros ^= n;
        }
        return new int[]{ones , zeros};
    }
}
