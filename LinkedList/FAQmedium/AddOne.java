package LinkedList.FAQmedium;

import LinkedList.ListNode;

public class AddOne {
     public ListNode addOne(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode lastNON9 = dummy;

        for (ListNode t = head; t != null; t = t.next) {
            if (t.val != 9) lastNON9 = t;
        }

        lastNON9.val++;

        for (ListNode t = lastNON9.next; t != null; t = t.next) {
            t.val = 0;
        }

        return dummy.val == 0 ? head : dummy;
    }
}
