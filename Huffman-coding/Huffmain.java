public class Huffmain {

  public static void main(String[] args) {
    String str = "suresh";
    huffman huff = new huffman(str);
    String ec = huff.encode(str);
    System.out.println("encode :" + ec);
    String dc = huff.decode(ec);
    System.out.println("decoded " + dc);
  }
}
