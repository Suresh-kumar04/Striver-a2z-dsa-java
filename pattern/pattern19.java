package pattern;

public class pattern19 {

  public static void main(String[] args) {
    // 2*n -i*2 found myself!!!
    // **********
    // *** ****
    // *** ***
    // ** **
    // * *
    // * **
    // ** **
    // *** ***
    // **** ****
    // **********
    int n = 5;
    for (int i = 1; i <= n; i++) {
      for (int j = n - i; j >= 0; j--) {
        System.out.print("*");
      }
      for (int space = 1; space < 2 * i - 1; space++) {
        System.out.print(" ");
      }
      for (int j = n - i; j >= 0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int space = 0; space < 2 * n - i * 2; space++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
