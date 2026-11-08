package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PhoneNumber {

    public List<String> letterCombinations(String digits) {
         Map<Character,String> map = new HashMap<>();      
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new ArrayList<>();
        helper(digits , new StringBuilder() , res ,map,0);
        return res;
    }


    void helper(String digits , StringBuilder sb , List<String> res,Map<Character,String> map,int i){

        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        char digit = digits.charAt(i);
        String possible = map.get(digit);

        for(char c : possible.toCharArray()){
            sb.append(c);
            helper(digits , sb , res , map , i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    
    }
}
