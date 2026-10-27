package BinarySearch;

import java.util.ArrayList;

public class FindKrotations {
    public static void main(String[] args) {
        int[] nums = { 15, 18, 2, 3, 6, 12 };
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(i);
        }
        int kRotations = findKRotation(arr);
        System.out.println("Number of rotations: " + kRotations);
    }
     public static int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int s =0,e = n-1;
        while(s <e){
            int mid = s+(e-s)/2;
            if(nums.get(mid) > nums.get(e)){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}
