package String.SumOfBeauty;

public class optimal {
      //O(N*N) 
    public int beautySum(String s) {
        int n = s.length();
        int sum =0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            int[] cnt = new int[n+2];
            int max = 0, min = Integer.MIN_VALUE;
              for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                int f = freq[c]++;
                cnt[f]--;
                cnt[f + 1]++;
                if (f + 1 > max) max = f + 1;
                if (f == 0) min = 1;
                else if (f == min && cnt[f] == 0) min = f + 1;
                sum += max - min;
            }
        }
        return sum;
    }
}
