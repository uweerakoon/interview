package commandalkine;

public class SquareNumber {

  public static boolean isSquare(int n) {
    double root = Math.sqrt(n);
    return (root - Math.floor(root)) == 0;
  }
  
  public static void main(String[] args) {
    System.out.println(SquareNumber.isSquare(25));
    System.out.println(SquareNumber.isSquare(26));
  }
}
