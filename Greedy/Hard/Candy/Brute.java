package Greedy.Hard.Candy;

public class Brute {

    public int candy(int[] ratings) {
        //O(3n) , O(2n)
        //since checking neighbour , check left and right
       int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] =1;
        right[n-1] =1;
        //------------------------------------------------->
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] +1;
            }else{
                left[i] =1;
            }
        }
        //<------------------------------------------------------------------
        for (int i = n-2; i >=0; i--) {
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1] +1;
            }else{
                right[i] = 1;
            }
        }
        int sum =0;
        for (int i = 0; i < right.length; i++) {
            sum += Math.max(right[i], left[i]);
        }
        return sum;
    }

}
