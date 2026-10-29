package BinarySearch.FAQ.Aggressivecows;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        
    }
    public int aggressiveCows(int[] nums, int cows) {
        Arrays.sort(nums);
        int s =1,e = nums[nums.length-1] - nums[0];
        int ans =0;
        while(s <= e){

            int mid = (s +e)/2;
            if(canPlace(nums , cows , mid) ){
                ans= mid;
                s = mid+1;
            }else{
                e=mid-1;
            }
        }
        // must return e cuz that the value u discarded with mid+1 
        return ans;
    }
    static boolean canPlace(int[] nums , int cows , int dist){
        int cow =1;
        int last = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i] - last >= dist){
                cow++;
                last = nums[i];
            }
            if(cow == cows) return true;
        } 
        return false;
    }
}
