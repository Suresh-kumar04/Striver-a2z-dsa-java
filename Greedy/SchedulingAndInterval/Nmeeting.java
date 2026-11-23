package Greedy.SchedulingAndInterval;

import java.util.Arrays;

public class Nmeeting  {
    class Pairs implements  Comparable<Pairs>{
        int start;
        int end;
        Pairs(int start, int end){
            this.start =start;
            this.end = end;
        }
        @Override
        public int compareTo(Pairs other) {
            return Integer.compare(this.end, other.end);
        }
    }
     public int maxMeetings(int[] start, int[] end) {
        Pairs[] pair = new Pairs[end.length];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = new Pairs(start[i], end[i]);
        }
        Arrays.sort(pair);
        int meeting =0;
        int nextFreeTime =-1; // for if a meeting starts at 0 
        for(Pairs p : pair){
            if(p.start > nextFreeTime){
                meeting++;
                nextFreeTime = p.end;
            }
        }
        return  meeting;
    }
}
