package Greedy.Hard.VPS.LinearIterative;

public class Better {
    //O(n) 
    public boolean checkValidString(String s) {
        // * adds three possible branch -> ( , "" , )
        // cant store them in singel variable so we use range
       int[] range = {0,0};
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch == '('){
            range[0]++;
            range[1]++;
        }else if(ch == ')'){
            range[0]--;;
            range[1]--;
        }else{
            //* for ')'
            range[0]--;
            //* for '('
            range[1]++;
        }
        if(range[0] < 0) range[0] =0;
        //if ')' count is negative , there's no way make it valid afterward
        if(range[1] < 0) return false;
       }
       return range[0] ==0;
    }
}
