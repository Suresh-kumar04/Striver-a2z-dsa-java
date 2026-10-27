package PriorityQueue;

public class main {

  public static void main(String[] args) throws Exception {
    PriorityQueue<Integer> pq = new PriorityQueue();
    pq.offer(44);
    pq.offer(43);
    pq.offer(44);
    pq.offer(-1);
    pq.offer(0);
    System.out.println(pq.poll());
    System.out.println(pq.peek());
    System.out.println(pq.peek());
  }
}
