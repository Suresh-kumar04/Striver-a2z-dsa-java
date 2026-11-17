package LinkedList.FAQdll;

import LinkedList.ListNode;

public class RemoveDuplicates {
    public ListNode removeDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode temp = head.next;
    while (temp != null) {
        if (temp.val == temp.prev.val) {
            if (temp.next != null) temp.next.prev = temp.prev;
            temp.prev.next = temp.next;   // needed/works for both tail and middle . prev cant be null cuz we start from head.next
        }
        temp = temp.next;
    }
    return head;
}
}
