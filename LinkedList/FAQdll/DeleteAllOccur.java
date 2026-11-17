package LinkedList.FAQdll;

import LinkedList.ListNode;

public class DeleteAllOccur {
    //optimal
public ListNode deleteAllOccurrences2(ListNode head, int target) {
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        if (curr.val == target) {
            if (curr.prev != null) curr.prev.next = curr.next;
            else head = curr.next;           // no prev means curr was the head
            if (curr.next != null) curr.next.prev = curr.prev;
        }
        curr = next;
    }
    return head;
}
    //brute
    public ListNode deleteAllOccurrences(ListNode head, int target) {
    ListNode temp = head;
    while (temp != null) {
        ListNode next = temp.next;          // save before unlinking
        if (temp.val == target) {
            if (temp.prev == null) {        // deleting the head
                head = temp.next;
                if (head != null) head.prev = null;
            } else if (temp.next == null) { // deleting the tail
                temp.prev.next = null;
            } else {                        // deleting a middle node
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
        temp = next;
    }
    return head;
}

}
