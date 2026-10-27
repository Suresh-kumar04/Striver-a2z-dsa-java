package BitSetClass;

import java.util.BitSet;

public class bitset {

  public static void main(String[] args) {
    int n = 100;
    BitSet composite = new BitSet(n + 1);

    for (int i = 2; i * i <= n; i++) {
      if (!composite.get(i)) {
        for (int j = i * i; j <= n; j += i) {
          composite.set(j);
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (!composite.get(i)) System.out.print(i + " ");
    }
  }
}
