package StriverDsa.BasicRecurrsion;

public class sumofN {

  public static void main(String[] args) {
    //    Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.

    // Example 1

    // Input : N = 4

    // Output : 10

    // Explanation : first four natural numbers are 1, 2, 3, 4.

    // Sum is 1 + 2 + 3 + 4 => 10.

    int n = 5;
    int res = sum(n);
    System.out.println(res);
  }

  private static int sum(int n) {
    if (n == 0) {
      return 0;
    }
    return n + sum(n - 1);
  }
}
