package StriverDsa.BinarySearch.SortedAndRotated;

public class Check {
    public static void main(String[] args) {
        
    }
     public int findMin(int[] nums) {
        int s =0,e = nums.length-1;
        while(s<e){
            int mid =  s+(e-s)/2;
            //if mid is greater than e then the min is in the right half
            if(nums[mid] > nums[e]){
                s= mid+1;
            }else{
                //no mid -1 because mid can be the ANSWER(minimum) so we will not eliminate it from the search space)
                e = mid;
            }
        }
        return nums[e];
    }
}
