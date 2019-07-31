package interview;

public class MaxChars {
  private static final int ASCII_SIZE = 256;
  public char maxChar(String str) {
    int count[] = new int[ASCII_SIZE];
    for(char c : str.toCharArray()) {
      count[c]++;
    }
    int max = -1;
    char result = ' ';
    for(char c : str.toCharArray()) {
      if(max < count[c]) {
        max = count[c];
        result = c;
      }
    }
    return result;
  }
  // time complexity = O(n) Space complexity = O(1)
  public static void main(String[] args) {
    MaxChars maxChars = new MaxChars();
    String str = "sample string";
    System.out.println("char: "+maxChars.maxChar(str));
  }
}
