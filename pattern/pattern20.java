package pattern;

public class pattern20 {

  public static void main(String[] args) {
    // * *
    // ** **
    // *** ***
    // **** ****
    // **********
    // **** ****
    // *** ***
    // ** **
    // * *

    int n = 5;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int space = 1; space <= 2 * n - i * 2; space++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }
    // bottom part
    for (int i = n - 1; i > 0; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int space = 1; space <= 2 * n - 2 * i; space++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }
}
