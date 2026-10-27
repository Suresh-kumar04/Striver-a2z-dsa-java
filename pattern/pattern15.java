package StriverDsa.pattern;

public class pattern15 {

  // ABCDE
  // ABCD
  // ABC
  // AB
  // A
  public static void main(String[] args) {
    int ch = 'A';
    int n = 5;
    for (int i = n; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print((char) (ch + j));
      }
      System.out.println();
    }
  }
}
