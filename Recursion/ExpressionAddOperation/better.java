package Recursion.ExpressionAddOperation;

import java.util.ArrayList;
import java.util.List;

public class better {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res ,num , target , new StringBuilder() , 0l , 0l,0);
        return res;
    }

    void dfs(List<String> res ,String num , int target , StringBuilder curr , long resSoFar , long prevNum , int start){
        if(start == num.length()){
            if(resSoFar == target){
                res.add(curr.toString());
                return;
            }
        }
        for(int end = start ; end < num.length();end++){
            //no leading 0 , but 0 at last is allowed
            if(start != end && num.charAt(start) =='0') break;

            long total = Long.parseLong(num.substring(start , end+1));
            int len = curr.length(); // remember len to undo later
            
            if(start==0){
                dfs(res , num , target , curr.append(total),total ,total ,end +1);
                curr.setLength(len);
            }else{
                //+
                dfs(res,num,target,curr.append("+").append(total),resSoFar+total , total , end+1);
                curr.setLength(len);

                //-
                dfs(res,num,target,curr.append("-").append(total),resSoFar-total , -total , end+1);
                curr.setLength(len);

                //multiple
                dfs(res,num,target,curr.append("*").append(total),
                //undo prev operation, do multiply first , then add it to ressofar
                resSoFar-prevNum + prevNum * total , total*prevNum , end+1);
                curr.setLength(len);
            }
        }
}
}
