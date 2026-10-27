package StriverDsa.EcluidPrecfectNumber;

public class TeranceTao {

  public static void main(String[] args) {
    // Euclid's theorem says that if 2^p − 1 is prime (a Mersenne prime), then 2^(p−1) × (2^p − 1) is a perfect number.
    // You give it p.
    // It converts p into 2^p − 1 (the Mersenne number).
    // It checks whether that is prime.
    // If yes, it builds 2^(p−1) × (2^p − 1) and prints it. That's the perfect number.
    isPerfect(6);
  }

  static boolean isPerfect(int p) {
    long Mersenne = (1L << p) - 1;
    if (!isPrime(Mersenne)) {
      return false;
    }
    long perfect = (1L << (p - 1)) * Mersenne;
    System.out.println("perfect is :" + perfect);
    return true;
  }

  static boolean isPrime(long n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
