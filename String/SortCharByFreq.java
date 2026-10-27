package StriverDsa.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharByFreq {

  public static void main(String[] args) {}

  public List<Character> frequencySort(String s) {
    // Your code goes here
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    List<Character> list = new ArrayList<>(map.keySet());
    list.sort((a, b) -> {
      //!= could cause logical erorr after Integer cahce exceeds
      if (!map.get(a).equals(map.get(b))) {
        return map.get(b) - map.get(a);
      }
      return a - b;
    });
    return list;
  }
}
