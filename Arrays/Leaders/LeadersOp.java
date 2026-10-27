package StriverDsa.Arrays.Leaders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersOp {
    public static void main(String[] args) {
        int[] arr = {-3, 4, 5, 1, -4, -5};
        System.out.println(leader(arr));
    }
    static List<Integer> leader(int[]arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int maxFromRight = arr[n-1];
        list.add(maxFromRight);
        for(int i=n-2;i>=0;i--){
            if(arr[i] >= maxFromRight ){
                list.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        Collections.reverse(list);
        return  list;

    }
}
