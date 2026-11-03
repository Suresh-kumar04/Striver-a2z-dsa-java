package Recursion.Basic;

public class WithoutAChar2 {
    public static void main(String[] args) {
        String s = "abc";
        char c = 'a';
        String ans = remove(s, c);
        System.out.println(ans);
    }
    static String remove(String s , char c){
        StringBuilder sb = new StringBuilder();
        helper(sb , 0, c ,  s);
        return  sb.toString();

    }
    static void helper(StringBuilder sb , int i , char c, String s){
        if(i == s.length()) return;
        if(s.charAt(i) != c){
            sb.append(s.charAt(i));
        }
        helper(sb, i+1, c, s);
    }
}
