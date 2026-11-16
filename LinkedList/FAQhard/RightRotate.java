package LinkedList.FAQhard;

import LinkedList.ListNode;

public class RightRotate {

     public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int n =1;
        ListNode temp = head;
        while(temp.next!= null){
            n++;
            temp=temp.next;
        }
        k = k%n;
        if(k==0) return head;
        temp.next = head;

        int steps = n-k;
        ListNode tail = head;
        for(int i=1;i<steps;i++){
            tail = tail.next;
        }
        ListNode newhead = tail.next;
        tail.next = null;
        return newhead;
    }
}
