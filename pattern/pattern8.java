package pattern;

class pattern8 {

  /*
  *********
  *******
  *****
   ***
    *
    
    
    */
  public static void main(String[] args) {
    int n = 5;
    for (int i = n; i > 0; i--) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i * 2 - 1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
