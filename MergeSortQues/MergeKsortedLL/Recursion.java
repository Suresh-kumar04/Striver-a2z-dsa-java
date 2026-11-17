package MergeSortQues.MergeKsortedLL;
import LinkedList.ListNode;

public class Recursion {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return divide(lists , 0 , lists.length-1);

    }
    ListNode divide (ListNode[] lists , int s , int e){
        if(s == e) return lists[s];
        int mid = s+(e-s)/2;

        ListNode left  = divide(lists , s , mid);
        ListNode right = divide(lists , mid+1 , e);

        return merge2List(left , right);

    }
    ListNode merge2List(ListNode l1 , ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2!=null){
            if(l1.val > l2.val){
                curr.next = l2;
                l2=l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr=curr.next;
        }
        curr.next = (l1 == null)?l2:l1;
        return dummy.next;
    }
}
