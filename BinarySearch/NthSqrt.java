public class NthSqrt {
    public static void main(String[] args) {
        System.out.println(NthRoot(3,27));
    }
     public static  int NthRoot(int N, int M) {
        int s =0, e= M;
        while(s <=e){
            int mid = s+(e-s)/2;
            long val = multiply(mid , N,M);
            if( val == M){
                return mid;
            }else if(val < M){
                s= mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }
    static long multiply(int n , int k,int Limit){
        long res =1;
        for(int i=1 ; i<=k;i++){
            res=  res*n;
            if(res > Limit) return Long.MAX_VALUE;
        }
        return res;
    }
}
