package StriverDsa.BasicRecurrsion;

public class ntoone {

  public static void main(String[] args) {
    int n = 5;
    helper(n);
  }

  private static void helper(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);
    helper(n - 1);
  }
}
