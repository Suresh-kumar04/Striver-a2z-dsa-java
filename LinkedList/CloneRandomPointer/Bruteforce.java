package LinkedList.CloneRandomPointer;

import java.util.HashMap;

public class Bruteforce {
    class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

     public Node copyRandomList(Node head) {
        //O(n) , O(n)
        HashMap<Node,Node> mpp = new HashMap<>();
        //create copies of every node
        for(Node temp = head;temp!=null;temp=temp.next){
            mpp.put(temp, new Node(temp.val));
        }

        Node temp = head;
        //connect next and random pointers
        while (temp!=null) {
            Node copy = mpp.get(temp);
            copy.next = temp.next;
            copy.random = temp.random;

            temp = temp.next;
        }
        return  mpp.get(head);
     
}
}
