package BinarySearch.SearchRoatedIMP;

public class withDupicates {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        boolean result = new withDupicates().search(arr, target);
        System.out.println("Target " + target + " found: " + result);
    }

    public boolean search(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == k)
                return true;
            // edge case only with duplicates
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                // if all 3 same means cant tell which side is sorted so shrink
                e--;
                s++;
                continue;
            }
            if (nums[s] <= nums[mid]) {
                // left half is sorted
                if (nums[s] <= k && k < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                // if left not sorted then right must be
                if (nums[mid] < k && k <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return false;
    }
}
