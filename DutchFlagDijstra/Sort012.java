package DutchFlagDijstra;
import LinkedList.ListNode;

public class Sort012 {
    public ListNode sortList(ListNode head) {
        ListNode zeroHead = new ListNode(), 
        oneHead = new ListNode(),
        twoHead = new ListNode();

        ListNode z = zeroHead,
         o = oneHead,
         t = twoHead;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (curr.val == 0) z = z.next = curr;
            else if (curr.val == 1) o = o.next = curr;
            else t = t.next = curr;
        }
        t.next = null;
        //connect from 2 to 1 first because if 1 is not present then we can connect 0 to 2 directly
        o.next = twoHead.next;
        z.next = oneHead.next;

        return zeroHead.next;
    }
}
