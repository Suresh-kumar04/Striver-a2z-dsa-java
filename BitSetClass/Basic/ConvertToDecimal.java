package BitSetClass.Basic;

public class ConvertToDecimal {
    public static void main(String[] args)  {
        System.out.println(toDecimal("1011"));
    }
    static int toDecimal(String binary) {
        int res = 0, exp =0;
        //right to left
        for (int i = binary.length()-1; i >=0; i--) {
            char ch = binary.charAt(i);
            if(ch != '1' && ch != '0') throw new NumberFormatException("not a binary : " + binary);
            
            if(ch == '1') res = res + (1<<exp);
            exp++;
        }
        Integer.parseInt(binary);
        return res;
    }
}
