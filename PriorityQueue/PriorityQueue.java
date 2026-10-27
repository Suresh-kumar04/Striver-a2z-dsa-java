package PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {

  private ArrayList<T> arr;

  public PriorityQueue(T data) {
    arr = new ArrayList<>();
  }

  public PriorityQueue() {
    arr = new ArrayList<>();
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private int left(int index) {
    return index * 2 + 1;
  }

  private int right(int index) {
    return index * 2 + 2;
  }

  public void offer(T data) {
    // adds at last
    arr.add(data);
    // satidfy the rule - every node must be smaller than its childern
    upheap(arr.size() - 1);
  }

  private void swap(int first, int second) {
    T temp = arr.get(first);
    arr.set(first, arr.get(second));
    arr.set(second, temp);
  }

  public T peek() throws Exception {
    if (arr.size() == 0) {
      throw new Exception("pq is empty");
    }
    return arr.get(0);
  }

  private void upheap(int index) {
    if (index == 0) {
      return;
    }
    int p = parent(index);
    if (arr.get(index).compareTo(arr.get(p)) < 0) {
      swap(index, p);
      upheap(p);
    }
  }

  public T poll() throws Exception {
    if (arr.isEmpty()) throw new Exception("pq is empty");
    T temp = arr.get(0);
    T last = arr.remove(arr.size() - 1);
    if (!arr.isEmpty()) {
      arr.set(0, last);
      downheap(0);
    }
    return temp;
  }

  private void downheap(int index) {
    int min = index;
    int left = left(index);
    int right = right(index);
    if (left < arr.size() && arr.get(min).compareTo(arr.get(left)) > 0) {
      min = left;
    }
    if (right < arr.size() && arr.get(min).compareTo(arr.get(right)) > 0) {
      min = right;
    }
    if (min != index) {
      swap(min, index);
      downheap(min);
    }
  }
}
