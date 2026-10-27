package StriverDsa.BinarySearch;

import java.util.Arrays;

public class FirstAndLast {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("First and last occurrence of " + target + " is: [" + result[0] + ", " + result[1] + "]");
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res , -1);
        int s=0, e=nums.length-1;
        while(s <=e){
            int mid = s+(e-s)/2;
            if(nums[mid] == target){
                res[0] = mid;
                e= mid-1;
            }else if(nums[mid] < target){
                s = mid+1;
            }
            else e =  mid-1;
        }
        s=0;e = nums.length-1;
        while(s <= e){
            int mid= s+(e-s)/2;
            if(nums[mid] == target){
                res[1] = mid;
                s = mid+1;
            }else if(nums[mid] < target){
                s = mid+1;
            }else{
                e= mid-1;
            }
        }
        return res;
}
}