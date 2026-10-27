package StriverDsa.pattern;

public class pattern9 {

  public static void main(String[] args) {
    /*
        
        
    * 
   ***
  *****
 *******
*********
*********
 *******
  *****
   ***
    *

        
        */
    int n = 5;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < n - i; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < i * 2 - 1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int l = n - 1; l > 0; l--) {
      for (int m = 0; m < n - l; m++) {
        System.out.print(" ");
      }
      for (int o = 0; o < 2 * l - 1; o++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
