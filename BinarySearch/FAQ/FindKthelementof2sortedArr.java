package BinarySearch.FAQ;

public class FindKthelementof2sortedArr {
    public static void main(String[] args) {
        
    }
      public int kthElement(int[] a, int[] b, int k) {
        int m = a.length, n = b.length;
        if (m > n) return kthElement(b, a, k);      // binary search the smaller array

        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int m1 = (low + high) >> 1;             // taken from a
            int m2 = k - m1;                        // taken from b

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (m1 < m) r1 = a[m1];
            if (m2 < n) r2 = b[m2];
            if (m1 >= 1) l1 = a[m1 - 1];
            if (m2 >= 1) l2 = b[m2 - 1];

            if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            else if (l1 > r2) high = m1 - 1;        // took too many from a
            else low = m1 + 1;                      // took too few from a
        }
        return -1;
    }
}
