package StriverDsa.Arrays.MergeTwoSortedArray;

import java.util.Arrays;

public class gfg {
    
    public static void main(String[] args) {
        // Given two sorted arrays a[] and b[] of size n and m respectively, merge both the arrays and rearrange the elements such that the smallest n elements are in a[] and the remaining m elements are in b[]. All elements in a[] and b[] should be in sorted order.
    }
    void merge(int arr1[] , int arr2[] , int n , int m){
       int left = n-1;
       int right =0;
         while(left >=0 && right < m){
                if(arr1[left] > arr2[right]){
                    int temp = arr1[left];
                    arr1[left] = arr2[right];
                    arr2[right] = temp;
                    left--;
                    right++;
                }else{
                    break;
                }
                
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
}
}
