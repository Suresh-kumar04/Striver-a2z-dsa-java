package Recursion.Basic;

public class SkipString {
    public static void main(String[] args) {
        System.out.println(skip("xxxxxxxxxxxxooolskkdk" , "ooo"));
    }
    static String skip(String s , String skip ){
        StringBuilder sb = new StringBuilder();
        helper(s, skip, sb);
        return sb.toString();
    }
    static void helper(String s , String skip , StringBuilder curr){
        if(s.isEmpty()) return;
        if(s.startsWith(skip)){
            helper(s.substring(skip.length()), skip, curr);
        }else{
            curr.append(s.charAt(0));
            helper(s.substring(1), skip, curr); 
        }

    }
}
