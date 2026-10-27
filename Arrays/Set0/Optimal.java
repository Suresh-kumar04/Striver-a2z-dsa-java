package StriverDsa.Arrays.Set0;

public class Optimal {
    public static void main(String[] args) {
        
    }
    public void setZeroes(int[][] matrix) {
        int r =  matrix.length;
        int c= matrix[0].length;
        // int col0 =1; 1 could cause bug
        //use col0 cuz ....we use the given matrix itself as boolean arr seen in brute 
        // we using 1st row and first col as array right
        //soo if both use 1st row and col , matrix[0][0] could be used for both
        //we dont want that hence let row take matrix[0][0]
        //keep variable col0 for that one col wowow just imagine
        // if(col0){
        //     for(int row =0;row<r;row++){ why this
        boolean col0 = false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] ==0){
                    matrix[i][0] =0;
                    if(j!=0){
                        matrix[0][j] =0;
                    }else{
                        col0 = true;
                    }

                }
            }
        }
        for(int  i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[0][j] ==0|| matrix[i][0] ==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0] ==0){
            for(int col =0;col<c;col++){
                matrix[0][col] =0;
            }
        }
        if(col0){
            for(int row =0;row<r;row++){
                matrix[row][0] =0;
            }
        }
    }
}
