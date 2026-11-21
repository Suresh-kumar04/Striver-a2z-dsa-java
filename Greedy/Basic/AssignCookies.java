package Greedy.Basic;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i < g.length && j < s.length){
            //i th child greed is smaller than cookie size
            if(g[i] <= s[j]){
                i++;
            }
            j++; //always move j
        }
        return i;
    }
}
