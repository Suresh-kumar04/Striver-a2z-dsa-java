package LinkedList.FAQhard.ReverseKgroups;

import LinkedList.ListNode;

public class Alternative {
    ListNode reverse(ListNode head) {
        ListNode node = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    // Find the Kth node from the current starting node
    ListNode getK(ListNode temp, int k) {
        k = k - 1;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode kthNode = getK(temp, k);

            // Fewer than k nodes remain
            if (kthNode == null) {
                if (prev != null) prev.next = temp;
                break;
            }

            // Store the next group's starting node
            ListNode newNode = kthNode.next;

            // Disconnect and reverse the current group
            kthNode.next = null;
            reverse(temp);

            // Connect the reversed group
            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            // Original group's first node becomes its tail
            prev = temp;
            temp = newNode;
        }
        return head;
    }
}
