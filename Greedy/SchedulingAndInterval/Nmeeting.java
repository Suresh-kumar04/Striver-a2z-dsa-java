package Greedy.SchedulingAndInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nmeeting  {
    class Pairs implements  Comparable<Pairs>{
        int start;
        int end;
        int pos;
        Pairs(int start, int end,int pos){
            this.start =start;
            this.end = end;
            this.pos = pos;
        }
        @Override
        public int compareTo(Pairs other) {
            return Integer.compare(this.end, other.end);
        }
    }
     public int maxMeetings(int[] start, int[] end) {
        Pairs[] pair = new Pairs[end.length];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = new Pairs(start[i], end[i],i);
        }
        Arrays.sort(pair);
        List<Integer> allMeeting = new ArrayList<>();
        // int meeting =0;
        int nextFreeTime =-1; // for if a meeting starts at 0 
        for(Pairs p : pair){
            if(p.start > nextFreeTime){
                allMeeting.add(p.pos);
                // meeting++;
                nextFreeTime = p.end;
            }
        }
        return  allMeeting.size();
    }
}
