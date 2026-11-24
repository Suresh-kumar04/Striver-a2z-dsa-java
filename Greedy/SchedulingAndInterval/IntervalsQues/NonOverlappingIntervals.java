package Greedy.SchedulingAndInterval.IntervalsQues;

import java.util.Arrays;

public class NonOverlappingIntervals {
    //same  as Nmeeting , build possible meetings first which will igoner the overapping one
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b) ->a[1] - b[1]);
        int last = intervals[0][1];
        int cnt =1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= last ){
                cnt++;
                last = intervals[i][1];
            }
        }
    return intervals.length - cnt;
}
}
