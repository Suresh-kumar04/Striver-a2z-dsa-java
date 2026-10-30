package BinarySearch.FAQ.FindMedian;

public class MergeApproach {
    public static void main(String[] args) {
        //O(n+m) time and O(1) space
    }
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length , n2=nums2.length;
        int n = n1+n2;
        int curr=0,prev=0;
        int i=0,j=0;
        for(int  mid = 0;mid <= (n>>1);mid++){
            prev = curr;
            if(i < n1 && j < n2){
                if(nums1[i] < nums2[j]){
                    curr = nums1[i++];
                }else{
                    curr = nums2[j++];
                }
            }else if(i < n1){
                curr = nums1[i++];
            }else{
                curr = nums2[j++];
            }
            
        }
        if((n &1 )==1) return curr;
        return (curr+prev)/2.0;
        
    }
}
