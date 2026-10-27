package HashingImp;

import java.util.HashMap;
import java.util.Map;

public class SumofHighestAndLowestFreq {

  public static void main(String[] args) {
    System.out.println(
        sumHighestAndLowestFrequency(new int[] { 1, 3, 3, 3, 3 }));
  }

  public static int sumHighestAndLowestFrequency(int[] nums) {
    int max = 0;
    int min = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      max = Math.max(max, map.get(i));
    }
    // cant put min up cuz .....
    // nums = [1, 1, 1, 2, 2]
    // 1 → 1
    // 1 → 2
    // 1 → 3 //max done
    // 2 → 1 ← min stays 1
    // 2 → 2
    for (int freq : map.values()) {
      min = Math.min(min, freq);
    }
    return max + min;
  }
}

// Given an array of n integers, find the sum of the frequencies of the highest
// occurring number and lowest occurring number.
