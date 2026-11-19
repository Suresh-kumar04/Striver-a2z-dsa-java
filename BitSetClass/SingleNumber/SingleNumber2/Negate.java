package BitSetClass.SingleNumber.SingleNumber2;

public class Negate {
    public int singleNumber(int[] nums) {
        int oneTime =0,twoTime =0;
        for(int n : nums){
            oneTime ^= (n & ~twoTime);
            twoTime ^= (n & ~oneTime);
        }
        return oneTime;
    }
}
