package BinarySearch;

public class LowerBound {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 4, 5, 6, 8 };
        int x = 4;
        int index = lowerBound(nums, x);
        System.out.println("Lower bound of " + x + " is at index: " + index);
    }

    public static int lowerBound(int[] nums, int x) {
        // The lower bound is the index of the first element that is greater than or
        // equal to x
        // eg. for x=4 in [1,2,4,4,5,6,8] the lower bound is 2
        int s = 0;
        int n = nums.length;
        int e = n - 1;
        int ans = n; // default: no element >= x
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] >= x) {
                ans = mid; // candidate, but maybe not the first
                e = mid - 1; // look further left
            } else {
                s = mid + 1; // nums[mid] < x, answer is to the right
            }
        }
        return ans;
    }

}
