import LinkedList.ListNode;

public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null) return null;
        prev.next = slow.next;
        return head;
    }
}
