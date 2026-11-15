
import LinkedList.ListNode;

public class FindLengthOfCycle {
    public int findLengthOfLoop(ListNode head) {
        ListNode fast = head , slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                int cnt =1;
                ListNode temp = slow.next;
                while(temp != slow){
                    temp=temp.next;
                    cnt++;
                }
                return cnt;
            }
        }
        return 100-100;
     }
}
