package StriverDsa.BasicMath;

/**
 * perfectNumber
 */
public class perfectNumber {

  public static void main(String[] args) {
    System.out.println(isPerfect(6));
  }

  public static boolean isPerfect(int n) {
    int sum = 1;
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (sum > n) return false;
      if (n % i == 0) {
        sum += i;
        if (i != n / i) {
          sum += n / i;
        }
      }
    }
    return sum == n;
  }
}
