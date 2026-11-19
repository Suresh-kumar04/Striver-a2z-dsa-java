package BitSetClass.SingleNumber.SingleNumber2;

public class Better {
    //approach -> count set bits and if its multiple of 3 , its not the single number , if not , then that setbit belongs to single number so copy that to the same position in ans using ans |= mask
     public int singleNumber(int[] nums) {
        int ans =0;

        for (int i = 0; i < 32; i++) {
            int mask = 1<<i;
            int setBits =0;
            for(int n : nums){
                if((n & mask) != 0) setBits++;
            }
            setBits %=3;
            if(setBits != 0){
                ans |= mask;
            }
        }
        return ans;
     }
}
