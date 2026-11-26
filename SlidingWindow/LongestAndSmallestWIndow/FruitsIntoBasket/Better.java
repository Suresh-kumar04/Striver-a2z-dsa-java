package SlidingWindow.LongestAndSmallestWIndow.FruitsIntoBasket;

import java.util.Map;
import java.util.HashMap;

public class Better {
    public int totalFruit(int[] fruits) {
        int max =0,l=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r = 0;r<fruits.length;r++){
            map.merge(fruits[r], 1, Integer :: sum);
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
