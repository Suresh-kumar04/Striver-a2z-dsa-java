package BinarySearch.BinarySearchOnAns;

public class SplitArray {
    public static void main(String[] args) {
        
    }
     public int splitArray(int[] nums, int k) {
         int low = 0, high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int p = getNoOfPieces(mid, nums, k);
            if (p <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int getNoOfPieces(int t, int[] nums, int k) {
        int piece = 1;
        int load = 0;
        for (int i = 0; i < nums.length; i++) {
            if (load + nums[i] > t) {
                piece++;
                if (piece > k) return piece;   // already too many, stop early
                load = nums[i];
            } else {
                load += nums[i];
            }
        }
        return piece;
    }
}
