package LinkedList.FAQdll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LinkedList.ListNode;

public class FindPairs {
     public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
       List<List<Integer>> res = new ArrayList<>();
       if(head == null) return res;
       ListNode left = head , right = head;

       while(right.next != null) right = right.next;
        // same as left.val < right.val
       while(left != right && right.next != left){
            int sum = left.val + right.val;
            if(sum < target){
                left = left.next;
            }else if(sum > target){
                right = right.prev;
            }else{
                res.add(Arrays.asList(left.val , right.val));
                left = left.next;
                right = right.prev;
            }
       }
        return res;
    }
}
