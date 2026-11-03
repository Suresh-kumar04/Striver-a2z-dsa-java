package Recursion.Basic;

public class WithoutAChar {
    // given a string s and char c return s removing all c;
    public static void main(String[] args) {
        String s = "abc";
        char c = 'a';
        String ans = remove("", s, c);
        System.out.println(ans);
    } 
    static String remove(String curr , String s , char c){
        if(s.isEmpty()) return  curr;

        if(s.charAt(0) == c) {
            return remove(curr, s.substring(1), c);
        }else{
            return remove(curr + s.charAt(0), s.substring(1), c);
        }

    }
}
