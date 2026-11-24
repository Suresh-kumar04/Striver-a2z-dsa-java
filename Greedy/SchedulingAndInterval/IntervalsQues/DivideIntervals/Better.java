package Greedy.SchedulingAndInterval.IntervalsQues.DivideIntervals;

import java.util.Arrays;
  // You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

    // You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.

    // Return the minimum number of groups you need to make.

    // Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.

public class Better {
//If multiple intervals overlap at a particular point, they must go into different groups. So, the core idea is to calculate the maximum number of overlaps at any time.
     public int minGroups(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int endPtr=0,meetingCount=0;

        for(int s : start ){
            if(s > end[endPtr]){
                endPtr++;
            }else{
                meetingCount++;
            }
        }
        return meetingCount;
    }
}
