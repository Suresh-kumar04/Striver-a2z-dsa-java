package SlidingWindow.LongestAndSmallestWIndow.FruitsIntoBasket;

import java.util.Map;
import java.util.HashMap;

public class Better {
    public int totalFruit(int[] fruits) {
        int max =0,l=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r = 0;r<fruits.length;r++){
            map.merge(fruits[r], 1, Integer :: sum);//add 1 to the count of this fruit type, and if the type isn't in the map yet, start it at 1."
            while(map.size() >2){
                int left = fruits[l];
                map.put(left , map.get(left)-1);
                if(map.get(left) ==0) map.remove(left);
                l++;
            }
            max = Math.max(max ,r-l+1);
            
        }
        return max;
    }
}
