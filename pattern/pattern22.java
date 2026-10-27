package StriverDsa.pattern;

public class pattern22 {

  public static void main(String[] args) {
    // 5 5 5 5 5 5 5 5 5
    // 5 4 4 4 4 4 4 4 5
    // 5 4 3 3 3 3 3 4 5
    // 5 4 3 2 2 2 3 4 5
    // 5 4 3 2 1 2 3 4 5
    // 5 4 3 2 2 2 3 4 5
    // 5 4 3 3 3 3 3 4 5
    // 5 4 4 4 4 4 4 4 5
    // 5 5 5 5 5 5 5 5 5

    int n = 5;
    for (int i = 1; i < n * 2 - 1; i++) {
      for (int j = 1; j < n * 2 - 1; j++) {
        int N = n * 2 - 1;
        int val = Math.min(Math.min(i, j), Math.min(N - i + 1, N - j + 1));
        int res = n - val + 1;
        System.out.print(res + " ");
      }
      System.out.println();
    }
  }
}
