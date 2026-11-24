package Greedy.SchedulingAndInterval.SchedulingQues.JobScheduling;

import java.util.Arrays;

public class Better {
     public int[] JobScheduling(int[][] jobs) {
        int maxDeadLine =0;
        for(int[] j : jobs){
            maxDeadLine = Math.max(maxDeadLine , j[1]);
        }
        Arrays.sort(jobs ,(a,b) -> b[2] - a[2]);
        int cnt =0,maxProfit=0;
        boolean [] days = new boolean [maxDeadLine+1];

        for(int[] job : jobs){
            for(int d = job[1] ; d>=1;d--){
            if(!days[d]){
                days[d] = true;
                cnt++;
                maxProfit+=job[2];
                break;
            }
            }
        }
        return new int[]{cnt , maxProfit};
    }
}
