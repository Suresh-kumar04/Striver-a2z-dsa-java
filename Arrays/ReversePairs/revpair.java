package StriverDsa.Arrays.ReversePairs;

public class revpair {
    public static void main(String[] args) {
        
    }
    
    public int reversePairs(int[] nums) {
       return mergeCount(nums , 0, nums.length-1,new int[nums.length]);
    }

    int countPairs(int[]arr , int low ,int mid, int high){
        int cnt =0;
        int rightP= mid+1;
        for(int i=low ;i<= mid ;i++){
            while(rightP <= high &&(long) arr[i] > arr[rightP] * 2L) rightP++;
            cnt += rightP - (mid +1);
        }
        
        return cnt;
    }
    int mergeCount(int[] arr , int low , int high,int[] temp ){
        if(low >= high) return 0;
        int cnt =0;
        int s = low;
        int e = high;
        int mid = s+(e-s)/2;
        cnt +=mergeCount(arr , s , mid,temp);
        cnt +=mergeCount(arr , mid+1 , e,temp);
        cnt += countPairs(arr,low,mid,high);
        int leftP = s;
        int rightP = mid+1;
        int arrayP = low;
        while(leftP <= mid && rightP <= e){
            if(arr[leftP] < arr[rightP] ){
                temp[arrayP++] = arr[leftP++];
            }else{
                temp[arrayP++] = arr[rightP++];
            }
        }
        while(leftP <=mid) temp[arrayP++] = arr[leftP++];
        while(rightP <=high) temp[arrayP++] = arr[rightP++];
        for(arrayP=low; arrayP <=high ;arrayP++) arr[arrayP] = temp[arrayP];
        return cnt;
    }
}
