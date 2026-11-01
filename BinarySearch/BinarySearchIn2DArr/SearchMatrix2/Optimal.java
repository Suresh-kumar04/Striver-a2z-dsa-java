package BinarySearch.BinarySearchIn2DArr.SearchMatrix2;

public class Optimal {
    public static void main(String[] args) {
        
    }
       public boolean searchMatrix(int[][] matrix, int target) {
        //view it as tree
        //   (<-decrease)
            /* 1 2 3 4
                     5(increase|)
                     6
                     7
            */
    int r =0,c = matrix[0].length-1;
    while(r < matrix.length && c >=0 ){
        int val = matrix[r][c];
        if(val == target) return true;
        else if(val > target) c--;
        else{
            r++;
        } 
    }
    return false;
}
}
