package Greedy.SchedulingAndInterval.SchedulingQues;

import java.util.Arrays;

public class ShortestJobFirst {
     public long averageWaitingTime(int[] burstTimes) {
        Arrays.sort(burstTimes);
        long currentTime =0,totalWaitingTime =0;
        for (int i = 0; i < burstTimes.length; i++) {
            totalWaitingTime+=currentTime;
            currentTime+=burstTimes[i];
        } 
        return totalWaitingTime/burstTimes.length;
     }
}
