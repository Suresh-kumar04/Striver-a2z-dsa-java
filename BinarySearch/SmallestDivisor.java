public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int limit = 6;
        System.out.println(smallestDivisor(nums, limit));
    }
      public static int smallestDivisor(int[] nums, int limit) {
        int e=nums[0];
       for(int n  : nums) e = Math.max(e , n);

       int s =1;
       while(s <=e){
        int mid = s+(e-s)/2;
        int val = sumByDivisor(nums,mid);
        if(val <= limit){
            e = mid-1;
        }else{
            s = mid+1;
        }
       }
       return s;
    }
    static int sumByDivisor(int[] nums , int div){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((double)nums[i]/(double)div);
        }
        return sum;
    }
}
