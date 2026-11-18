package BitSetClass.Basic;

public class ConvertToBinary {
    public static void main(String[] args) {
        System.out.println(toBinary(11));
    }

    static String toBinary(int n){
        if(n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            sb.append(n%2);
            n /=2;
        }
        return sb.reverse().toString();
    }
}
