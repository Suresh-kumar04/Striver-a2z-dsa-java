package LinkedList.LogicBuilding;

public class ReverseSingleLL {
    public ListNode reverseList(ListNode head) {
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
