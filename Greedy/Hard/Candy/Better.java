package Greedy.Hard.Candy;

public class Better {
    //O(2N) , O(N)
      public int candy(int[] ratings) {
        int[] can = new int[ratings.length];
        can[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                can[i] = can[i-1] +1; 
            }else{
                can[i] =1;
            }
        }
        int curr =1, right  = 1 , sum = Math.max(1, can[ratings.length-1]);
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                curr = right+1;
                right = curr;
            }else{
                curr=1;
                right =1;
            }
            sum += Math.max(curr, can[i] );
        }
        return sum;
    }
}
