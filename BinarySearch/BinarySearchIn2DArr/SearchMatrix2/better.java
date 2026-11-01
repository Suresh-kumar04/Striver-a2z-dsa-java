package BinarySearch.BinarySearchIn2DArr.SearchMatrix2;

public class better {
    public static void main(String[] args) {
        // Rows sorted left to right, columns sorted top to bottom
        //whole matrix is NOT sorted 
// matrix = [[1, 4, 7, 11, 15],
//           [2, 5, 8, 12, 19],
//           [3, 6, 9, 16, 22],
//           [10, 13, 14, 17, 24],
//           [18, 21, 23, 26, 30]]
// target = 5
    }
      public boolean searchMatrix(int[][] matrix, int target) {
        //o(m log n)
        for (int[] row : matrix) {
            if (bs(row, target)) return true;
        }
        return false;
    }

    boolean bs(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
