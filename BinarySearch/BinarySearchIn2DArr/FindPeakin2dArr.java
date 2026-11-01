package BinarySearch.BinarySearchIn2DArr;

public class FindPeakin2dArr {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length , n = mat[0].length;
        int low =0,high = m-1;//row length so m-1
        while(low <= high){
            int mid = low +(high - low)/2;
            int maxColIdx = findColMax(mat , mid);
            int top = mid-1 >=0 ? mat[mid-1][maxColIdx]: -1;
            int bottom = mid+1 < m ? mat[mid+1][maxColIdx]:-1;
            if(mat[mid][maxColIdx] > top && mat[mid][maxColIdx] > bottom){
                return new int[]{mid , maxColIdx};
            }else if(mat[mid][maxColIdx] < top){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return null;
    }
    int findColMax (int[][] mat , int row ){
        int max =0;
        int maxIdx=0;
        for(int i=0;i<mat[row].length;i++){
            if(mat[row][i] > max){
                maxIdx = i;
                max = mat[row][i];
            }
        }
        return maxIdx;
    }
}
