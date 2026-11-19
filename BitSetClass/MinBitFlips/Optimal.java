package BitSetClass.MinBitFlips;

public class Optimal {
    //Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
    public int minBitFlips(int n, int goal) {
        int xor = n ^ goal; // xor makes different bits as 1
        int cnt =0;
        while (xor!=0) {
            //xor-1 clears first set bit 
            //ANDing keeps the remaining bits same
            //loop till no set bit remains 
            xor &= (xor-1);
            cnt++;
        }
        return cnt;
    }
}
