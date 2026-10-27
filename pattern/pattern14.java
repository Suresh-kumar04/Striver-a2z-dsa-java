package StriverDsa.pattern;

public class pattern14 {

  /*
    A
    A B
    A B C
    A B C D
    A B C D E
    */
  public static void main(String[] args) {
    int ch = 'A';
    int n = 5;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print((char) (ch + j) + " ");
      }
      System.out.println();
    }
  }
}
