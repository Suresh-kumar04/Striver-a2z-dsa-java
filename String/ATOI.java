package String;

public class ATOI {
      public int myAtoi(String s) {
        int i=0,n = s.length();
        while(i < n && s.charAt(i) == ' ') i++;
        if(i==n) return 0;
        int sign =1;
        if(s.charAt(i)== '-'){
            sign =-1;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
    long res =0;
    while(i < n){
        char ch = s.charAt(i);
        if(ch < '0' || ch >'9') break;
        int num = ch -'0';
        res = res * 10 + num;
        if(sign * res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign * res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        i++;
    }


    return (int) (res * sign);
    
    }
}
