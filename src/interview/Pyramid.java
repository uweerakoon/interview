package interview;

public class Pyramid {

  public void pyramid(int n) {
    if(n <= 0)
      return;
    double midPoint = Math.floor((2*n-1) / 2);
    StringBuilder sb = new StringBuilder();
    for(int row = 0; row < n; row++) {  // # rows
      for(int column=0; column < 2*n-1; column++)  // # columns
        sb.append((midPoint - row <= column && midPoint + row >= column) ? "#" : " ");
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
  
  public void pyramid(int n, int column, int row, StringBuilder sb) {
    if(row == n) {
      System.out.println(sb.toString());
      return;
    }
    if(column == 2*n-1) {
      pyramid(n, 0, ++row, sb.append("\n"));
      return;
    }
    double midPoint = (2*n-1) /2;
    sb.append(column >= midPoint - row && column <= midPoint+row ? "#" : " ");
    pyramid(n, ++column, row, sb);
  }
  
  public static void main(String[] args) {
    Pyramid pyramid = new Pyramid();
    pyramid.pyramid(3);
    pyramid.pyramid(3, 0, 0, new StringBuilder());
  }
}
