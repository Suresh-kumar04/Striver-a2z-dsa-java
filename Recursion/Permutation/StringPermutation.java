package Recursion.Permutation;
import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        List<String> lis = new ArrayList<>();
        String s = "abc";
        permute(s.toCharArray(), lis, 0);
        System.out.println(lis);
    }

    private static void permute(char[] s , List<String> res , int i) {
        if(i == s.length){
            res.add(new String(s));
            return ;
        }
        for(int low =i ; low<s.length;low++){
            swap(s , low , i);
            permute(s, res, i+1);
            swap(s, i, low);
        }

    }
    private static  void swap(char[] s , int i , int j){
        char t = s[i];
        s[i] = s[j];
        s[j] =t;
    }
    
}