package Greedy.Hard.Candy;

public class Slope {

    public int candy(int[] ratings) {
    //O(n) , O(1)
        int sum =1,up=0,down =0, peak=0;

        for (int i = 1; i < ratings.length; i++) {
            //flat
            if(ratings[i] == ratings[i-1]){
                up = down = peak =0;//reset current slope is flat
                sum += 1;
            }else if(ratings[i] > ratings[i-1]){//upward slope
                down=0;
                up++;
                peak = up;
                sum = sum + up + 1;
            }else{//downward slope
                up=0;
                down++;
                //we take max of down and peak cuz only that covers both left and right half of array (neighbours)
                sum = sum + down + (down > peak ? 1 : 0);
            }
           
        }
        return sum;
    }
}
