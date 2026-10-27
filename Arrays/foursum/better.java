package StriverDsa.Arrays.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class better {
    public static void main(String[] args) {
        
    }
     public List<List<Integer>> fourSum(int[] nums, int target) {
         HashSet<List<Integer>> sorted = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> st = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = (long)nums[i] + nums[j] + nums[k];
                    long fourth = target -(sum);
                    if(st.contains(fourth)){
                        List<Integer> quad = Arrays.asList(nums[i]
                        ,nums[j],nums[k],(int)fourth
                        );
                        Collections.sort(quad);
                        sorted.add(quad);
                    }
                    st.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(sorted);
    
    }
}
