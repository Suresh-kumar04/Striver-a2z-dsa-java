package Greedy.SchedulingAndInterval.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeOptimized {
    //O(n+maxval)
      public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int maxStart = 0;
        for(int[] interval : intervals){
            maxStart = Math.max(maxStart , interval[0]);
        }

        int[]endOf = new int[maxStart+1];
        Arrays.fill(endOf , -1);

        for(int[] interval : intervals){
            int s = interval[0],e = interval[1];
            endOf[s] = Math.max(endOf[s] , e); 
        }

        boolean hasGroup = false;
        int groupStart = 0, groupEnd =0;

        for(int i =0;i<=maxStart;i++){
            if(endOf[i] ==-1) continue;
            
            if(!hasGroup){
                groupStart = i;
                groupEnd = endOf[i];
                hasGroup = true;

            }else if(i <= groupEnd){
                groupEnd = Math.max(groupEnd , endOf[i]);
            }else{
               if(hasGroup) res.add(new int[]{groupStart , groupEnd});
                //new interval
                groupStart = i;
                groupEnd = endOf[i];
            }
        }
        // add last interval manually
        res.add(new int[]{groupStart , groupEnd});
        return res.toArray(new int[0][]);
    }
}
