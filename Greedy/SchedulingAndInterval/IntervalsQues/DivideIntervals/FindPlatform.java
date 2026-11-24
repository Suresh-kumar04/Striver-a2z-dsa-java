package Greedy.SchedulingAndInterval.IntervalsQues.DivideIntervals;

import java.util.Arrays;

public class FindPlatform {
     public int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int i =0,j=0;
        int cnt =0, maxCnt =0;
        while(i < Arrival.length){
            if(Arrival[i] <= Departure[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt , cnt);
        }

        return maxCnt;
    }
}
