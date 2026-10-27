package EcluidPrecfectNumber;

public class EculidPerfect {

  public static void main(String[] args) {
    System.out.println(isPerfect(6));
  }

  static boolean isPrime(long n) {
    if (n < 2)
      return false;
    for (long i = 2; n * n <= i; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  static long EuclidPerfect(long p) {
    // Euclid's theorem says that if 2^p − 1 is prime (a Mersenne prime), then
    // 2^(p−1) × (2^p − 1) is a perfect number.
    long Mersenne = (1L << p) - 1;
    if (!isPrime(Mersenne)) {
      return 0;
    }
    return (1L << (p - 1)) * Mersenne;
  }

  static boolean isPerfect(long n) {
    // long max = 2^63 - 1 (-1 for sign bit)
    // Perfect number = 2^(p-1) * (2^p - 1)
    // approximately 2^(2p - 1)
    // Therefore 2p - 1 < 63
    // So p <= 31
    for (int p = 2; p <= 31; p++) {
      long perfect = EuclidPerfect(p);
      if (perfect == 0)
        continue;
      if (perfect > n)
        return false;
      if (perfect == n)
        return true;
    }
    return false;
  }
}
