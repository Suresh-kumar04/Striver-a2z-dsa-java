package LinkedList.FAQhard.ReverseKgroups;

import LinkedList.ListNode;

public class Recursion {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode tail = head;

        for(int i=0;i<k;i++){
            if(tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = rev(head , tail);
        newHead.next = reverseKGroup(newHead, k);
        return  newHead;


    }
    static ListNode rev(ListNode head , ListNode end){
        ListNode prev = null;
        while(head != end){
            ListNode nextnode = head.next;
            head.next = prev;
            prev =  head;
            head = nextnode;
        }
        return  prev;
    }
}
