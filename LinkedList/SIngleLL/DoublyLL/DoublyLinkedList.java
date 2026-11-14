package LinkedList.SIngleLL.DoublyLL;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;




public class DoublyLinkedList<T> implements Iterable<T> {

    private  int size ;
    private int modCount;
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
// -----------------------add----------------------------------------------
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
        modCount++;
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
        modCount++;
    }
     public void addAtFront(T data){
        Node<T> newnode = new Node<>(data);
        if(head == null){
            head = tail = newnode;
            size++;
            modCount++;
            return ;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
        size++;
        modCount++;
    }

    // ------------------------remove----------------------------------------------
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
        modCount++;
        return removed;

    }
     public T removeLast(){
        if (head == null) throw new NoSuchElementException();
        T removed = tail.data;
        tail = tail.prev;
        if(tail == null) head = null;
        else tail.next = null;
        size--;
        modCount++;
        return removed;
    }

    public T removeFirst(){
        if (head == null) throw new NoSuchElementException();
        T removed = head.data;
        head = head.next;
        if(head == null) tail=null;
        else head.prev = null;
        size--;
        modCount++;
        return removed;

    }

    //----------------get&set-----------------------------


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

    public int indexOf(T val){
        int idx =0;
        Node<T> temp = head;
        while(temp != null){
            if(Objects.equals(val , temp.data)) return idx;
            idx++;
            temp= temp.next;
        }
        return -1;
    }

    public T set(int index , T value){
        if(index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
        
        Node<T> old = getNode(index);
        T oldVal = old.data;
        old.data = value;
        return oldVal;
    }

    public boolean contains(T val){
        if(head == null) return  false;
        Node<T> first = head , last = tail;
        while (first != null && last != null) {
            if(Objects.equals(first.data, val) || Objects.equals(val, last.data)){
                return  true;
            }
        if(first == last || first.next == last) return false;
        first = first.next;
        last = last.prev;
        }
        return false;
    }

   
    // ------------------miscellaneous----------------------
    public boolean isEmpty(){
        return size ==0;
    }

    public int getSize(){
        return  this.size;
    }

    public void clear(){
        if(size==0) return ;
        head = null;
        tail=null;
        modCount++;
        size=0;
    }
//-------------iteration--------------------
    @Override
    public Iterator<T> iterator() {
        int expMod = modCount;
        return new Iterator<T>(){

            private Node<T> current = head;

            private void checkMod(){
                if(modCount != expMod){
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
              checkMod();
              if(!hasNext()){
                 throw new NoSuchElementException();
              }
              T value = current.data;
              current = current.next;
              return value;

            }

          
        };
    }
    public Iterator<T> descendingIterator(){
        int expMod = modCount;
        return  new Iterator<T>() {
            private Node<T> current = tail;

            @Override
            public boolean hasNext() {
               return current!=null;
            }

            private void checkMod(){
                if(expMod != modCount){
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public T next() {
                checkMod();

                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T val = current.data;
                current = current.prev;
                return val;
            }
            
        };
    }

}
