package Greedy.SchedulingAndInterval.InserInterval;

import java.util.Arrays;

public class Better {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res= new int[intervals.length+1][2];
        int newStart =newInterval[0], newEnd = newInterval[1];
        int i=0;

        while(i < intervals.length && intervals[i][1] < newStart){
            res[i] = intervals[i];
            i++;
        }

        int temp =i;
        int rangeStart = newStart;
        int rangeEnd = newEnd;

        while(i < intervals.length && intervals[i][0] <= rangeEnd){
            rangeStart = Math.min(rangeStart , intervals[i][0]);
            rangeEnd = Math.max(rangeEnd , intervals[i][1]);
            i++;
        }
        res[temp++] = new int[]{rangeStart , rangeEnd};

        for(int j = i ; j < intervals.length ; j++){
            res[temp++] = intervals[j];
        }

        return Arrays.copyOf(res, temp);
    }
}
