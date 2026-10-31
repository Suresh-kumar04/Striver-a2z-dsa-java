package BinarySearch.FAQ.GasStation;

public class brute {
    public static void main(String[] args) {
        
    }
     public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[]howManyWays = new int[n-1];
        for (int i = 1; i <=k; i++) {
            int maxIndx =-1;double maxsecLen=-1;
            for(int j=0;j<n-1;j++){
                double diff = arr[j+1]-arr[j];
                          //howmanyways arr is 0 initially so first put gas station
                double sectionLength = diff/(double)(howManyWays[j]+1);
                if(sectionLength > maxsecLen ){
                    maxsecLen = sectionLength;
                    maxIndx =j;
                }
            }
            howManyWays[maxIndx]++;
        }
        double ans =-1;
        for(int i=0;i<n-1;i++){
            double diff = arr[i+1] - arr[i];
                                                        //same
            double sectionLength = diff/(double)(howManyWays[i]+1);
            ans = Math.max(ans, sectionLength);
        }
        return ans;
    }
}
