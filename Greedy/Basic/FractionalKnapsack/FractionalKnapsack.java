package Greedy.Basic.FractionalKnapsack;

import java.util.Arrays;

public class FractionalKnapsack {

    class Pair implements Comparable<Pair>{
        //could cause precision error due to division due to floating point division
        int val;
        int wt;
        Pair(int val,int wt){
            this.val=val;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair other) {
            return Double.compare((double)other.val/other.wt,(double) this.val/this.wt);
        }
    }
     public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        Pair[] pair = new Pair[val.length];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = new Pair(val[i],wt[i]);
        }
        Arrays.sort(pair);
        double totalval =0;
        for(Pair p : pair){
            if(cap <=0) break;
            if(p.wt <= cap){
                totalval += p.val;
                cap -= p.wt;
            }else{
                totalval += (double) p.val/p.wt * cap;
                break;
            }
        }
        return totalval;
    }
}
