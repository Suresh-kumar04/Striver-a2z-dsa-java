package BinarySearch.BinarySearchOnAns;

public class BookAllocation {
    public static void main(String[] args) {
        
    }
    public int findPages(int[] nums, int m) {
        int n = nums.length;
        if(m > n) return -1;
        int s=0;
        int e =0;
        for(int num : nums){
            s = Math.max(s , num);
            e += num;
        }
        //ranges of pages
        while(s <=e){
            int mid = s+(e-s)/2;
            int Stud = getStudents(nums , mid);
            if(Stud <= m){
                e = mid-1;
            }else{
                s =  mid+1;
            }
        }
        return s;
    }

        static int getStudents(int[] books ,int pages){
            int student =1;
            int page = 0;
            for(int i=0;i<books.length ;i++){
                if(books[i] + page > pages ){
                    page = books[i];
                    student++;
                }else{
                    page += books[i];
                }
            }
            return student;
        }
    
}
