package SlidingWindow.LongestAndSmallestWIndow.FruitsIntoBasket;

import java.util.Map;
import java.util.HashMap;

public class FixedwindowApproach {
    public int totalFruit(int[] fruits) {
        int l=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r = 0;r<fruits.length;r++){
            map.merge(fruits[r] , 1 , Integer::sum);
            if(map.size() > 2){
                int left = fruits[l];
                // if(map.put(left , map.get(left)-1) == 0){
                //     map.remove(left);
                // }put returns old value so use merge
                if(map.merge(left , -1 , Integer::sum) ==0){
                    map.remove(left);
                }
                l++;//always move forward with last max valid window size
            }
        }
        return fruits.length -l;
    }
}
