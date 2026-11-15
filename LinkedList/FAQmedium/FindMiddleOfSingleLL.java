package LinkedList.FAQmedium;

import LinkedList.ListNode;

public class FindMiddleOfSingleLL {
     public ListNode middleOfLinkedList(ListNode head) {
        ListNode fast = head ,slow = head;
        while(fast  !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
}
