package StriverDsa.BinarySearch;

public class CountOccurance {
    public static void main(String[] args) {
        
    }
       public int countOccurrences(int[] nums, int target) {
        //                 target +1 ' s occurrance - target ' s occurance
        return lowerbound(nums, target+1) - lowerbound(nums , target);
       
    }
    static int lowerbound(int[] nums, int target){
        int s = 0 , e = nums.length;
        while(s < e){
            int mid = s +(e-s)/2;
            if(nums[mid] < target){
                s= mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}
