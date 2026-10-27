package BinarySearch.SearchRoatedIMP;

public class BSinRoatedArr {
    public static void main(String[] args) {

    }

    class Solution {
        public int search(int[] nums, int k) {
            int s = 0, e = nums.length - 1;

            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] == k)
                    return mid;
                if (nums[s] <= nums[mid]) {
                    // say it out loud , if the array is sorted and
                    // k is in the range
                    if (nums[s] <= k && k < nums[mid]) {
                        e = mid - 1;
                    } else {
                        // not in range
                        s = mid + 1;
                    }
                } else {
                    // left half was not sorted
                    // THEREFORE RIGHT IS SORTEd
                    if (nums[mid] < k && k <= nums[e]) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
