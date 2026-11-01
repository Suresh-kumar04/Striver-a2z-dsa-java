package BinarySearch.BinarySearchIn2DArr.RowWithMax1s;

public class Better {
    public static void main(String[] args) {
        // O(m log n)
    }
     public int rowWithMax1s(int[][] mat) {
       int maxOnes = 0;
       int ans =-1;
       int r =0;
       for(int[] row : mat){
            int ones =bs(row);
            if(ones>maxOnes){
                maxOnes = ones;
                ans = r;
            }
            r++;
       }
       return ans;
    }
    int bs(int[] row){
        int low=0,high = row.length-1, max=0;
        while(low <= high){
            int mid = low +(high - low)/2;
            if(row[mid] == 1){
                max = Math.max(max , row.length - mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return max;
    }
}
