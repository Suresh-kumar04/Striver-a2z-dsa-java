package LinkedList.CloneRandomPointer;

public class Optimal {
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
    //O(n) , O(1)
        Node temp = head;
        //copy val and connect copy next to orignal
        while(temp!=null){
            Node copy =new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        //assign random pointer;
        temp = head;
        while(  temp!=null && temp.next != null){
            temp.next.random = temp.random ==null
                                            ?null
                                            :temp.random.next;//no temp.random cuz it will link to original list , copy is next to it
            temp = temp.next.next;
        }
        //remove pointer
        Node dummy = new Node(-1), curr = dummy;
        temp = head;
        while(temp != null){
            Node copy = temp.next;
            temp.next = copy.next;

            curr.next = copy;
            curr=curr.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}