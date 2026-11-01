package BinarySearch.BinarySearchIn2DArr.RowWithMax1s;

public class Optimal {
     public int rowWithMax1s(int[][] mat) {
       int maxR =-1;
       int j=mat[0].length-1;
       for(int i =0;i<mat.length;i++){
            while(j>=0 && mat[i][j] ==1){
                maxR =i;
                j--;
            }
       }
       return maxR;
    }
    
}
