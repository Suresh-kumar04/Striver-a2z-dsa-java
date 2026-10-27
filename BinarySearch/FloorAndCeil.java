package BinarySearch;

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6, 8, 10 };
        int x = 5;
        int[] result = getFloorAndCeil(nums, x);
        System.out.println("Floor and Ceil of " + x + " are: [" + result[0] + ", " + result[1] + "]");
    }
    public  static int[] getFloorAndCeil(int[] nums, int x) {
      int s=0,e=  nums.length-1,floor=-1,ceil=-1;
      while(s <= e){
        int mid = s + (e-s)/2;
        if(nums[mid] == x){
            return new int[]{x,x};
        }else if(nums[mid] < x){
            floor = nums[mid];
            s = mid+1;
        }else{
            ceil=  nums[mid];
            e = mid-1;
        }
      }
      return new int[]{floor,ceil};
    }
}
