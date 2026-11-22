package Greedy.Basic.FractionalKnapsack;

import java.util.Arrays;

public class Optimal {
    // fixes precision error , handles negative or zero wt and val
    class Pair implements Comparable<Pair>{
        int val;
        int wt;
        Pair(int val,int wt){
            this.val=val;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair other) {
            return Long.compare(
                (long)other.val*this.wt,
                (long) this.val*other.wt
                //cross multiply
                // v1 / w1  >  v2 / w2
                //= v1 * w2 > v2*w1
            );
        }
    }
     public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        Pair[] pair = new Pair[val.length];
        double totalval =0;

        int pairIdx =0;
        for (int i = 0; i < pair.length; i++) {
            if(wt[i] < 0) continue;    //will sabotage
            if(val[i] <= 0) continue;  //never worth taking
            if(wt[i] ==0){             // free item
                totalval += val[i];
                continue;
            }
            pair[pairIdx++] = new Pair(val[i], wt[i]); 
        }
        
        Arrays.sort(pair,0,pairIdx); //sort till valid ones 
        for(int i=0;i<pairIdx;i++){
            Pair p = pair[i];
            if(cap <=0) break;
            if(p.wt <= cap){
                totalval += p.val;
                cap -= p.wt;
            }else{
                totalval += (double) p.val * cap/p.wt;//multiply before division to increase precision
                break;
            }
        }
        return totalval;
    }
}

