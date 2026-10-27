package Arrays.ReapetingAndMissing;

import BasicRecurrsion.one;

public class xor {
    public static void main(String[] args) {

    }

    static int[] zor(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }
        // The missing and repeating numbers are different at diffBit, so they go into
        // different piles.
        int diffBit = 0;
        while (true) {
            if ((xor & (1 << diffBit)) != 0) {
                break;
            }
            diffBit++;
        }
        int ones = 0, zeros = 0;
        for (int num : nums) {
            int t = num >> diffBit;
            if ((t & 1) == 1) {
                ones = ones ^ num;
            } else {
                zeros = zeros ^ num;
            }
        }

        for (int i = 1; i <= n; i++) {
            int t = i >> diffBit;
            if ((t & 1) == 1) {
                ones = ones ^ i;
            } else {
                zeros = zeros ^ i;
            }
        }

        int cnt = 0;
        for (int x : nums) {
            if (x == ones)
                cnt++;
        }
        return cnt == 2 ? new int[] { ones, zeros } : new int[] { zeros, ones };
    }
}
