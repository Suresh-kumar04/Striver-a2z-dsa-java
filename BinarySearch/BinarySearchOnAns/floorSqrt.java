package BinarySearch.BinarySearchOnAns;
public class floorSqrt {
    public static void main(String[] args) {
        System.out.println(floorSqrt(4));
        System.out.println(floorSqrt(8));
    }
     public static  int floorSqrt(int n) {
        if(n<2) return n;
      int s=0,e=n;
      while(s <= e){
        int mid = s+(e-s)/2;
        //can avoid long by checking mid <=n/mid
        long val = (long)mid*mid;
        if(val > n){
            e=  mid-1;
        }else{
            s = mid+1;
        }
      }
      return e;
    }

}
