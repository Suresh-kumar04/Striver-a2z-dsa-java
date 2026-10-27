package pattern;

public class pattern18 {

  // D
  // C D
  // B C D
  // A B C D
  public static void main(String[] args) {
    int n = 4;
    int ch = 'A' + n - 1;
    System.out.println((char) ch);

    for (int i = 1; i <= n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        System.out.print((char) (ch - j));
      }
      System.out.println();
    }
  }
}
