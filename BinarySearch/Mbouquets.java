package BinarySearch;

public class Mbouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println("Minimum days to make " + m + " bouquets is: " + roseGarden(bloomDay.length, bloomDay, k, m));
    }
     public static int roseGarden(int n, int[] bloomDay, int k, int m) {
        if((long)m*k > n) return -1; 

        int s =bloomDay[0],e=bloomDay[0];
        for(int flower : bloomDay){
            s = Math.min(s , flower);
            e = Math.max(e , flower);
        }
        while(s <= e){
            int mid = s+(e-s)/2;
            int val = isPossible(bloomDay , mid ,m , k);
            if(val < m){
                s= mid+1;// not enough bouquets -> wait longer
            }else{
                e = mid-1;// enough -> try fewer days
            }

        }
        return s;

    }
    static int isPossible(int[] bloomDay , int day ,int  m, int k){
       int adj=0;
       int totalBouquets=0;
       int i =0;
       while(i < bloomDay.length){
            if(bloomDay[i] <= day){
                adj++;
                if(adj == k){
                    totalBouquets++;
                    if(totalBouquets == m) return m;
                    adj=0;
                }
            }
            else{
                adj=0;
            }
        i++;
       }
       return totalBouquets;
    }
}
