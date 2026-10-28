package BinarySearch.BinarySearchOnAns;

import java.util.Arrays;

public class PaintersPartition {
    public static void main(String[] args) {
        
    }
     public  static int paint(int painters, int time, int[] board) {
          long high = Arrays.stream(board).asLongStream().sum();
          long low  = Arrays.stream(board).max().getAsInt();
        while(low <= high){
            long mid = low + (high - low)/2;
            int p = getNoOfPainters(painters,mid, board);
            if(p <=painters){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return (int) ((long) low * time % 10000003);
    }
    static int getNoOfPainters(int painters ,long t ,int[] board){
        int painter =1;
        long time =0;
        for(int i=0;i<board.length;i++){
            if(time + board[i]> t){
                painter++;
                time = board[i];
            }else{
                time+= board[i];
            }
        }
        return painter;
    }
}
