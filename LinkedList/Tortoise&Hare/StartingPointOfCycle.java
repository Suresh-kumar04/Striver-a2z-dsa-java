
import LinkedList.ListNode;

public class StartingPointOfCycle {
    
    public ListNode findStartingPoint(ListNode head) {
        if(head == null) return null;
        ListNode fast = head , slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast=head;
                while(slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        
        return null;
    }
}
