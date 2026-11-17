package LinkedList;

public class SortLL {
     public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;
        //start fast from head.next to make sure slow is at mid for even length list
        // example 1->2->3->4, slow should be at 2
        // for odd length list, slow will be at mid, example 1->2->3->4->5, slow will be at 3
        // if start fast from head, then for even length list, slow will be at mid+1, example 1->2->3->4, slow will be at 3
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;


        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,right);
        
    }
    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!=null && l2 != null){
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null)?l2:l1;
        return dummy.next;
    }
}
