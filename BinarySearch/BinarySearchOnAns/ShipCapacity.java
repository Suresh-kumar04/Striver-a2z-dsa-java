package BinarySearch.BinarySearchOnAns;

public class ShipCapacity {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println("Minimum capacity to ship all packages within " + days + " days is: " + shipWithinDays(weights, days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        // Your code goes here
        int s= weights[0], e =0;
        for(int w : weights){
            s = Math.max(s , w);
            e += w;
        }
        while(s <=e){
            int mid = s+(e-s)/2;
            int daysForCurrCap = getDays(weights , mid);
            if(daysForCurrCap <= days){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    static int getDays(int[] W , int capacity){
        int day =1 , load =0;
        for(int w : W){
            if(w + load > capacity){
                day++;
                load = w;
            }else{
                load+= w;
            }
        }
        return day;
    }
}
