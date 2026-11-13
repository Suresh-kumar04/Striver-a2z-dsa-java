package LinkedList.SIngleLL.DoublyLL;

import java.util.NoSuchElementException;



public class DoublyLinkedList<T> {

    private  int size ;
    private static  class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data , Node<E> next , Node<E> prev){
            this.data = data;
            this.next =  next;
            this.prev = prev;
        }
        
        Node(E data){
            this.data = data;
        }

    }
    
    private Node<T> head,tail;

    public void add(T data){
        Node<T> newnNode = new Node<>(data);
        if(head == null){
            head = tail = newnNode;
        }else{
            newnNode.prev = tail;
            tail.next = newnNode;
            tail = newnNode;
        }
        size++;
    }

    private  Node<T> getNode(int index){
        if(index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
        
        Node<T> temp ;
        if(index < size / 2){
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else{
            temp = tail;
            for (int i = size-1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public T getVal(int index){
       return getNode(index).data;
    }

    public void add(T data , int index){
        if(index < 0 || index > size)
        throw new IndexOutOfBoundsException();

        if(index == 0){
            addAtFront(data);
            return ;
        }
        if(index == size){
            add(data);
            return ;
        }
        Node<T> node = new Node<>(data);
        Node<T> temp = getNode(index-1);
        node.next = temp.next;
        node.prev = temp;

        temp.next.prev = node;
        temp.next = node;
        size++;

    }

    public void addAtFront(T data){
        Node<T> newnode = new Node<>(data);
        if(head == null){
            head = tail = newnode;
            size++;
            return ;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
        size++;
    }

    public T remove(int index){
        if(index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
        
        if(index == size-1){
           return removeLast();
        }

        if(index ==0){
           return  removeFirst();   
        }

        Node<T> temp = getNode(index);
        T removed = temp.data;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev=null;

        size--;
        return removed;

    }

    public T removeLast(){
        if (head == null) throw new NoSuchElementException();
        T removed = tail.data;
        tail = tail.prev;
        if(tail == null) head = null;
        else tail.next = null;
        size--;
        return removed;
    }

    public T removeFirst(){
        if (head == null) throw new NoSuchElementException();
        T removed = head.data;
        head = head.next;
        if(head == null) tail=null;
        else head.prev = null;
        size--;
        return removed;

    }

    public int getSize(){
        return  this.size;
    }


}
