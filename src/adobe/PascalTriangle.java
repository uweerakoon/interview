package adobe;

public class PascalTriangle {

//  1  
//  1 1 
//  1 2 1 
//  1 3 3 1 
//  1 4 6 4 1 
//  1 5 10 10 5 1 
  // O(n^3) time complexity
  public void pascal(int n) {
    for(int line=0; line < n; line++) {
      for(int i=0; i<=line; i++) {
        System.out.print(getCoeffienct(line,i)+" ");
      }
      System.out.println();
    }
  }
  
  public int getCoeffienct(int n, int k) {
    int res = 1;
    if(k > n-k) {
      k = n - k;
    }
    for(int i=0; i < k; i++) {
      res *= (n - i);
      res /= (i+1);
    }
    return res;
  }
  
  // A O(n^2) time and O(n^2) extra 
  public void pascal2D(int n) {
    int[][] array = new int[n][n];
    for(int line=0; line<n; line++) {
      for(int i=0; i <= line; i++) {
        if(i == 0 || i == line) {
          array[line][i] = 1;
        } else {
          array[line][i] = array[line-1][i-1] + array[line-1][i];
        }
        System.out.print(array[line][i]+" ");
      }
      System.out.println();
    }
  }
  
//A O(n^2) time and O(1) extra
  public void pascalPrevious(int n) {
    for(int line=1; line <= n; line++) {
      int c = 1;
      for(int i=1; i <= line ; i++) {
        System.out.print(c+" ");
        c = c * (line - i) / i;
      }
      System.out.println();
    }
  }
  
  
  public static void main(String[] args) {
    PascalTriangle pascalTriangle = new PascalTriangle();
//    pascalTriangle.pascal(7);
//    pascalTriangle.pascal2D(7);
    pascalTriangle.pascalPrevious(7);
  }
}
