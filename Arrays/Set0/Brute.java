package Arrays.Set0;

public class Brute {
    public static void main(String[] args) {

    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;
            // extra space is used hence brute
            boolean[] rowZero = new boolean[r];
            boolean[] colZero = new boolean[c];

            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    if (matrix[i][j] == 0) {
                        rowZero[i] = true;
                        colZero[j] = true;
                    }

            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    if (rowZero[i] || colZero[j])
                        matrix[i][j] = 0;
        }
    }
}
