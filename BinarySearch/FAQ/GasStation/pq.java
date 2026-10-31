package BinarySearch.FAQ.GasStation;

import java.util.PriorityQueue;


public class pq {

    static class Pairs{
        double section;
        int index;
          Pairs(double section , int index){
            this.section = section;
            this.index = index;
          }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        System.out.println(minimiseMaxDistance(arr, k));

    }
    public static double minimiseMaxDistance(int[] arr, int k) {

        int[] howManyWays = new int[arr.length-1];
         PriorityQueue<Pairs> pq = new PriorityQueue<>(
            (a,b)->Double
            .compare(b.section, a.section)
        );

        for(int i=0;i<arr.length-1;i++){
            
            pq.offer(new Pairs(arr[i+1] - arr[i] , i));
        }

        for(int i=1;i<=k;i++){
            Pairs maxSection = pq.poll();
            int sectionIndex = maxSection.index;
            howManyWays[sectionIndex]++;
            double oldDiff = arr[sectionIndex+1] - arr[sectionIndex];
            double newSection = oldDiff/(double)(howManyWays[sectionIndex]+1);
            pq.offer(new Pairs(newSection, sectionIndex));
            
        }
        return pq.peek().section;
    }    

}
