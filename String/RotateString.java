package String;

public class RotateString {

  public static void main(String[] args) {
  }

  // brute force

  public boolean rotateString(String s, String goal) {
    String copy = s;
    // your code goes here
    for (int i = 0; i < s.length(); i++) {
      if (copy.equals(goal))
        return true;
      copy = copy.substring(1) + copy.charAt(0);
    }
    return false;
  }

  // optimized
  public boolean rotateString2(String s, String goal) {
    if (s.length() != goal.length())
      return false;
    return (s + s).contains(goal);
  }
}
