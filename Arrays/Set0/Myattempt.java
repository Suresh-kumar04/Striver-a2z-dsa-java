package Arrays.Set0;

public class Myattempt {
    // i set r an c to intmaxvalue instead of 0 to avoid ambiguity
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < r; k++) // whole column
                        if (matrix[k][j] != 0)
                            matrix[k][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < c; k++) // whole row
                        if (matrix[i][k] != 0)
                            matrix[i][k] = Integer.MAX_VALUE;
                }
            }
        }

        // second pass: turn markers into 0
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = 0;
    }
}
