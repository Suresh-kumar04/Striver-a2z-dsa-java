package LinkedList.FAQhard;

import LinkedList.ListNode;

public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1, l2 = list2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                curr.next =  l2;
                l2 =  l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        //add remaining nodes if any
        curr.next = (l1==null)?l2:l1;
        return dummy.next;
    }
}

