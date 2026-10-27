package BinarySearch.BinarySearchOnAns;

public class koko {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("koko can eat bananas at a minimum rate of " + minimumRateToEatBananas(piles, h) + " bananas per hour.");
    }
    public static int minimumRateToEatBananas(int[] piles, int h) {
        int e =piles[0];
        for(int n : piles) e = Math.max(n , e);
        //hours ,so divide i.e if she eats 11 banana out of 11 pile of banana its 
        //11/11 = 1hr not minus
        int s =1;
        //[1 - max[piles] bananas]
        while(s <= e){
            int mid = s +(e-s)/2;
            long totalH =0 ;
            for(int n : piles){
                totalH += (n+mid-1)/mid;
                if(totalH > h) break;
            }
            if(totalH > h){
                s= mid+1;
            }else{
                e = mid-1;
            }
        }
        return s;
    }
    
}
