package StriverDsa.Arrays;

import java.util.ArrayList;
import java.util.List;

public class spiral {
    // last 2 loops need && li.size() < total why/=??
    public static void main(String[] args) {
        
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int r= matrix.length;
        int c = matrix[0].length;
        int top = 0;
        int left =0;
        int right = c-1;
        int bott = r-1;
        List<Integer> li = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        while(li.size() < total){
            for(int i=left ; i <=right ; i++){
                li.add(matrix[top][i]);
            }
            top++;
            for(int i=top ; i<=bott;i++){
                li.add(matrix[i][right]);
            }
            right--;
            for(int i=right;i>=left && li.size() < total;i--){
                li.add(matrix[bott][i]);
            }
            bott--;
            for(int i=bott;i>=top && li.size() < total;i--){
                li.add(matrix[i][left]);
            }
            left++;
        }
        return li;
    }
}
