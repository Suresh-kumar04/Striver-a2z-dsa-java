package String;

public class RemoveOuterParentheses {
     public String removeOuterParentheses(String s) {
        int cnt =0;
        StringBuilder sb =  new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(cnt >0){
                    sb.append(ch);
                }
            }else{
                cnt--;
                if(cnt >0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();                 
    }
}
