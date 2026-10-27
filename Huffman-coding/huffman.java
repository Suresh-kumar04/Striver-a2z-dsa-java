import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class huffman {

  HashMap<Character, String> encoder;
  HashMap<String, Character> decoder;

  class Node implements Comparable<Node> {

    Node left, right;
    char data;
    int cost;

    public Node(char data, int cost) {
      this.data = data;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
      return this.cost - other.cost;
    }
  }

  public huffman(String feeder) {
    HashMap<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < feeder.length(); i++) {
      char ch = feeder.charAt(i);
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
      pq.add(new Node(entry.getKey(), entry.getValue()));
    }
    while (pq.size() > 1) {
      Node first = pq.poll();
      Node secont = pq.poll();
      Node newNode = new Node('\0', first.cost + secont.cost);
      newNode.left = first;
      newNode.right = secont;
      pq.offer(newNode);
    }
    Node root = pq.peek();
    encoder = new HashMap<>();
    decoder = new HashMap<>();
    setTreeFreq(root, "");
  }

  private void setTreeFreq(Node root, String osf) {
    if (root == null) return;
    // why rleaf node?
    if (root.left == null && root.right == null) {
      encoder.put(root.data, osf);
      decoder.put(osf, root.data);
    }
    setTreeFreq(root.left, osf + "0");
    setTreeFreq(root.right, osf + "1");
  }

  public String encode(String source) {
    String ans = "";
    for (char ch : source.toCharArray()) {
      ans += encoder.get(ch);
    }
    return ans;
  }

  public String decode(String encodedStr) {
    String key = "";
    String decodedStr = "";
    for (int i = 0; i < encodedStr.length(); i++) {
      char ch = encodedStr.charAt(i);
      key += ch;
      if (decoder.containsKey(key)) {
        decodedStr += decoder.get(key);
        key = "";
      }
    }
    return decodedStr;
  }
}
