package StriverDsa.MajorityElement;

public class nby2 {
    public static void main(String[] args) {
        
    }
     public int majorityElement(int[] nums) {
        int len = nums.length;
        int count =0;
        int candidate = nums[0];
        for(int n : nums){
            if(n == candidate) count ++;
            else{
                count --;  
            }
            if (count ==0){
                candidate = n;
                count++;
            }
        }
        //NEED IF MAJORITY ELEMENT ISNT GUARANTEED!!!!
        count =0;
        for(int n : nums){
            if(n == candidate) count++;
        }
        
        return count> (len/2) ? candidate : -1;
    }
}
