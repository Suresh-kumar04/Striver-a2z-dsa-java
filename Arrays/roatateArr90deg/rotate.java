package Arrays.roatateArr90deg;

/**
 * rotate
 */
public class rotate {
    public static void main(String[] args) {

    }

    public void rotateMatrix(int[][] matrix) {
        /*
         * Rotate 90° clockwise = transpose, then reverse each row
         * 
         * Original Transpose Reverse each row
         * 1 2 3 1 4 7 7 4 1
         * 4 5 6 -> 2 5 8 -> 8 5 2
         * 7 8 9 3 6 9 9 6 3
         * 
         * Transpose: swap a[i][j] with a[j][i], only for j > i (each pair once)
         * Reverse row: swap row[l] with row[r], moving l and r toward the middle
         * Overall: (i, j) -> (j, n-1-i)
         */
        int n = matrix.length;
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        // rev rows
        for (int[] row : matrix) {
            int l = 0;
            int r = row.length - 1;
            while (l < r) {
                int t = row[l];
                row[l] = row[r];
                row[r] = t;
                l++;
                r--;
            }
        }
    }

}