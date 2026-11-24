package Greedy.Hard.VPS.LinearIterative;

public class Optimal {
    public boolean checkValidString(String s) {
        //dropped range array from better approah
        int low =0,high =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                low++;
                high++;
            }else if(ch == ')'){
                low --;
                high--;
            }else{
                low--;
                high++;
            }
            if(low < 0 ) low =0;
            if(high <0) return  false;
        }
        return low ==0;
    }
}
