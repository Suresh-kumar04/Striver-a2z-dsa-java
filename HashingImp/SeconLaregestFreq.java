package StriverDsa.HashingImp;

import java.util.HashMap;
import java.util.Map;

public class SeconLaregestFreq {

  public static void main(String[] args) {}

  public int secondMostFrequentElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int firstMax = 0;
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
      firstMax = Math.max(firstMax, map.get(n));
    }
    int secondMax = 0;
    int E = Integer.MAX_VALUE;

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int freq = entry.getValue();
      int element = entry.getKey();
      if (freq < firstMax) {
        //instead of Math.max ... imp
        if (freq > secondMax) {
          secondMax = freq;
          E = element;
        }
        //if same count , return smalllest as per question
        else if (freq == secondMax) {
          if (element < E) {
            secondMax = freq;
            E = element;
          }
        }
      }
    }
    return E == Integer.MAX_VALUE ? -1 : E;
  }
}
// Given an array of n integers, find the second most frequent element in it.

// If there are multiple elements that appear second most frequent times, find the smallest of them.

// If second most frequent element does not exist return -1.
