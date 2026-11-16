package LinkedList.FAQhard.ReverseKgroups;

import LinkedList.ListNode;

public class better {
    //O(n)t O(1)space
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode prevTail = dummy;

        ListNode temp = head;
        int size =0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        int batch = size /k;
        temp = head;
        while(temp != null && batch -->0 ){
            ListNode batchHead = temp;
            ListNode curr = temp;
            for(int i=0;i<k-1;i++){
                curr = curr.next;
            }
            ListNode nextnode = curr.next;
            curr.next = null;
            prevTail.next = rev(batchHead);
            batchHead.next =  nextnode;
            prevTail = batchHead;
            temp = nextnode;
        }
        return dummy.next;
    }
    ListNode rev(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode nextnode = head.next;
            head.next = prev;
            prev = head;
            head = nextnode;
        }
        return prev;
    }
}
