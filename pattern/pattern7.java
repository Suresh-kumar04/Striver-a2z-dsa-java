package StriverDsa.pattern;

public class pattern7 {

  /*
   * Pattern:
   *     *
   *    ***
   *   *****
   *  *******
   * *********
   */
  public static void main(String[] args) {
    int temp = 0;
    int n = 5;
    for (int i = 1; i <= n; i++) {
      // space
      for (int j = 0; j < n - i; j++) {
        System.out.print(" ");
      }
      // use 2*i -1 for interview
      for (int k = 1; k <= i + temp; k++) {
        System.out.print("*");
      }
      temp++;
      System.out.println();
    }
  }
}
