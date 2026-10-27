package StriverDsa.pattern;

public class pattern21 {

  public static void main(String[] args) {
    // *****
    // *   *
    // *   *
    // *   *
    // *****

    int n = 5;
    for (int i = 1; i <= n; i++) {
      if (i == 1 || i == n) {
        for (int j = 1; j <= n; j++) {
          System.out.print("*");
        }
      } else {
        System.out.print("*");
        for (int space = 1; space <= n - 2; space++) {
          System.out.print(" ");
        }
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
