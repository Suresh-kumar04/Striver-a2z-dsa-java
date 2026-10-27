package BasicRecurrsion;

public class one {

  public static void main(String[] args) {
    int n = 5;
    helper(n, 1);
  }

  private static void helper(int n, int start) {
    if (start == n) {
      System.out.println(start);
      return;
    }
    System.out.println(start);
    helper(n, start + 1);
  }
}
