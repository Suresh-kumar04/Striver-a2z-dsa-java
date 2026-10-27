package StriverDsa.BinarySearch;

import StriverDsa.BasicRecurrsion.one;

public class soBeauty {
    public static void main(String[] args) {
        // Given an array nums sorted in non-decreasing order. Every number in the array except one appears twice. Find the single number in the array.
        //if correctly paired , it will look like (0,1) (2,3) (4,5) (6,7) (8,9) (10,11) (12,13) (14,15)
        // so when on even idex (0 is even) check next index 
        //if odd index (1 is odd) check previous index
        //thats exactly what xor does , it flips the last bit of the number , so 0^1 = 1 and 1^1 = 0
        //zor checks forward if even and 
        // backward if odd
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int single = singleNonDuplicate(nums);
        System.out.println("The single number in the array is: " + single);
        
    }
    public static int singleNonDuplicate(int[] nums) {
      int s=0,e=nums.length-1;
      while(s < e){
        int mid = s+(e-s)/2;
        if(nums[mid] ==nums[mid^1] ){
            s= mid+1;
        }else{
            e = mid;
        }
    }
    return nums[s];
}
}
