
public class CountInverstion {
    public static void main(String[] args) {
        int[] nums = {2,3,12,44,55,1};
      long res= mergCount(nums, 0, nums.length-1, new int[nums.length]);
      System.out.println(res);
        
    }
// Merge sort works because both halves are sorted before merging.
// If left[i] > right[j], then left[i..mid] are ALL > right[j]
// (left half is sorted), so we add (mid - i + 1) inversions in one step
// instead of checking each pair one by one.
// Brute force O(n^2) -> merge sort O(n log n).
    static long mergCount(int[] nums,int low , int high,int[] temp){
        if(low >= high) return 0;
        long cnt =0;
        int s = low;
        int e = high;
        int mid = s + (e -s)/2;
        cnt +=mergCount(nums , s , mid,temp);
        cnt +=mergCount(nums , mid+1 , e,temp);

        int leftP = low;
        int rightP =  mid+1;
        int arrayP = low;

        while(leftP <= mid && rightP <= high){
            if(nums[leftP] <= nums[rightP]){
                temp[arrayP++] = nums[leftP++];
            }else{
                temp[arrayP++] = nums[rightP++];
                cnt += (mid - leftP +1);
            }
        }
        while(leftP <=mid) temp[arrayP++] = nums[leftP++];
        while(rightP <=high) temp[arrayP++] = nums[rightP++];
        for(arrayP=low; arrayP <=high ;arrayP++) nums[arrayP] = temp[arrayP];
        return cnt;

    }
}
