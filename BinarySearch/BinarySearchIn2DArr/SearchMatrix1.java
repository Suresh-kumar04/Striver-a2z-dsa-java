package BinarySearch.BinarySearchIn2DArr;

public class SearchMatrix1 {
    public static void main(String[] args) {
         
    }
    public boolean searchMatrix(int[][] matrix, int target) {
     if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m =  matrix.length , n = matrix[0].length;
        int low =0,high = m*n-1;
        while(low <= high){
            int mid = low + (high-low)/2;

            int r = mid/n, c= mid%n;

            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
