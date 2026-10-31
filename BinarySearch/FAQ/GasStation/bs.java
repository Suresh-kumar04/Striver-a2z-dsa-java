package BinarySearch.FAQ.GasStation;

public class bs {
    public static void main(String[] args) {
        
    }
    class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);   
        }
        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            int cnt = getNumberOfStation(arr, mid);
            if (cnt > k) low = mid;
            else high = mid;
        }
        return high;
    }

    int getNumberOfStation(int[] arr, double dist) {
        int gasStation = 0;
        for (int i = 1; i < arr.length; i++) {
            int gap = arr[i] - arr[i - 1];
            int section = (int) (gap / dist);              
            if (gap == dist * section) {                   
                section--;
            }
            gasStation += section;
        }
        return gasStation;
    }
}
}
