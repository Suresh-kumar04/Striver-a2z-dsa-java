package LinkedList.SIngleLL;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> {
    private   int size;
    private static class Node<E>{
        E data;
        Node<E> next;

        Node(E data ){
            this.data = data;
        }

        Node(E data , Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head , tail;

    public void add(T data){
        Node<T> newnode = new Node<>(data);
        if(head == null){
            head = tail = newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }
        
        size++;
    }

    public void insertAtFront(T data){
        if(head == null){
            add(data);
            return ;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T deleteAtFront() {
        if (head == null) throw new NoSuchElementException("list is empty");

            T removed = head.data;
            head = head.next;
            if (head == null) tail = null;
            size--;
        return removed;
    }

    public T deleteAtEnd(){
        if(head == null) throw new NoSuchElementException("list is empty");
        T removed = tail.data;
        if(head.next == null){
            head = tail = null;
            size=0;
            return removed;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp=temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
        return removed;
    }

    public T get(int index){
        if(head == null) throw new NoSuchElementException("List is empty");
        if(index == size-1) return tail.data;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + ", size " + size);

        Node<T> temp =  head;
        for(int i=0 ;i<index;i++ ){
            temp=temp.next;
        }

        return  temp.data;
    }

    public boolean insertAt(int index, T data){
        if(index > size || index <0) return false;
        if(index == 0){
            insertAtFront(data);
            return true;
        }
        if(index == size){
            add(data);
            return true;
        }
        Node<T> newnNode = new Node<>(data);
        Node<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.next;
        }
        newnNode.next = temp.next;
        temp.next = newnNode;
        size++;
        return true;

    }

    public boolean deleteAt(int index){
        if(head == null) throw new NoSuchElementException("List is empty");
        if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException("index " + index + ", size " + size);
        if(index ==0){
            deleteAtFront();
            return  true;
        }
        if(index == size-1){
            deleteAtEnd();
            return true;
        }
        Node<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    public int indexOf(T data){
        if(head == null) throw new NoSuchElementException("List is empty");
        int idx=0;
        for(Node<T> temp = head ; temp != null ; temp=temp.next){
            if(Objects.equals(temp.data, data)) return idx;
            idx++;
        }
        return -1;
    }

    public boolean contains(T data){
        if(head == null) throw new NoSuchElementException("List is empty");
        for(Node<T> temp = head ; temp != null ; temp=temp.next){
            if(Objects.equals(temp.data, data)) return true;
        }
        return false;
    }

    public int getSize(){

        return this.size;
    }

    public boolean isEmpty(){

        return  this.size ==0;

    }

    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(Node<T> temp = head ; temp != null ; temp = temp.next){
            sb.append(temp.data);
            if(temp.next != null) sb.append("->");
        }
        return sb.append("]").toString();
    }

    public void clear(){
        head = tail = null;
        size =0;
    }

}
