package StriverDsa.pattern;

public class pattern17 {

  public static void main(String[] args) {
    //      A
    //    ABA
    //   ABCBA
    //  ABCDCBA
    // ABCDEDCBA
    int n = 5;
    int ch = 'A';
    // int temp = ch;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.print((char) (ch + k));
      }
      for (int l = i - 2; l >= 0; l--) {
        System.out.print((char) ('A' + l));
      }

      // while(ch>='A'){
      //     System.out.print((char)ch--);
      // }
      System.out.println();
    }
  }
}
