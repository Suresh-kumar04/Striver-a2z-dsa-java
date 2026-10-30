package BinarySearch.FAQ;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
     public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n = n1+n2;
        if(n1 > n2) return findMedianSortedArrays(nums2 , nums1);
        int s=0 ,e =n1;
        while( s<= e){
            int mid1 = (s+e)>>1;
            int mid2 = ((n+1)/2)-mid1;//You do take the rest from nums2 after choosing from nums1, but “the rest” means the rest of the left half, not the rest of everything ie(n-mid1).
            int l1= Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1>=1) l1= nums1[mid1-1];
            if(mid2>=1) l2 = nums2[mid2-1];
            if(mid1 < n1 ) r1=nums1[mid1];
            if(mid2 < n2) r2=nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                                    //if used n/2 for odd(mid2), it beacomes math.min
                if((n &1) ==1) return Math.max(l1,l2);
                                
                return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2.0;
            }else if(l1 > r2) e = mid1-1;
            else s = mid1+1;

        }
        return 69;
    }
}
