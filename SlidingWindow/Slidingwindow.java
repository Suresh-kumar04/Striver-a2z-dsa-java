package SlidingWindow;

public class Slidingwindow {
    //find maxlen of subarray whose sum <=k
    public int maxLen(int[] nums,int k){
        int l=0,r=0,maxLen =0;
        int sum =0;
        while (r < nums.length) {
            int len =0;
            sum += nums[r];
            while (sum >k) {
                sum -= nums[l++];
            }
            len = r-l+1;
            maxLen = Math.max(maxLen, len);
            r++;
        }

        return  maxLen;
    }
}
