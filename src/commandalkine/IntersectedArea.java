package commandalkine;

public class IntersectedArea {

  public static void main(String[] args) {
    
    int x1 = 1, y1 = 2, x2 = 3, y2 = 4, x3 = 2, y3 = 1, x4 = 4, y4 = 3;
    double area = Math.abs(Math.max(x1, x3) - Math.min(x2, x4)) * Math.abs(Math.max(y1, y3) - Math.min(y2, y4));
    System.out.println(area);
  }
}
