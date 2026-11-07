package Recursion;

import java.util.ArrayList;
import java.util.List;

public class generateBinaryString {
    public List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();
        helper(res , n , new StringBuilder() , '0');
        return res;
    }
    void helper(List<String> curr , int n , StringBuilder sb,char prev){
        if(n == 0){
            curr.add(sb.toString());
            return;
        }
       sb.append("0");
       helper(curr , n-1, sb,'0');
       sb.deleteCharAt(sb.length()-1);

       if(prev != '1'){
    
        sb.append("1");
        helper(curr , n-1 , sb , '1');
        sb.deleteCharAt(sb.length()-1);
       }


    }
}
