package LinkedList.FAQmedium;

import LinkedList.ListNode;

public class Plaindrome {
     public boolean isPalindrome(ListNode head) {
         if(head == null) return true;
        //for even length , start fast from head.next which also covers for odd len; 
        // or choose secondhalf from slow then fast will start form head
        ListNode fast = head.next ,slow = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        ListNode reved  =  rev(secondHalf); 
        ListNode copy = reved;

        ListNode first = head;
        boolean isPali = true;
        while(reved !=null){
            if(first.val != reved.val) {
                isPali = false;
                break;
            }
            first = first.next;
            reved = reved.next;
        }
        //restore original list
        slow.next =rev(copy);
        return isPali;

    }
    ListNode rev(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode nextnode = head.next;
            head.next = prev;
            prev = head;
            head = nextnode;
        }
        return prev;
    
    }
}
