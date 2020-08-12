package interview;

public class Fibonacci {

  public int fibIterate(int n) {
    int[] series = new int[n+1];
    series[1] = 1;
    for(int i=2; i<=n; i++) {
      series[i] = series[i-2] + series[i-1];
    }
    return series[n];
  }
  
  public int fibRecursive(int n) {
    if(n < 2) {
      return n;
    }
    return fibRecursive(n-2) + fibRecursive(n-1);
  }
  
  public int fibMemoization(int n) {
    int[] memo = new int[n+1];
    return fibMemoization(n, memo);
  }
  
  public int fibMemoization(int n, int[] memo) {
    if(n < 2) {
      return n;
    }
    if(memo[n] > 0) {
      return memo[n];
    }
    memo[n] = fibMemoization(n-1, memo) + fibMemoization(n-2, memo);
    return memo[n];
  }
  
  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    System.out.println(f.fibIterate(4));
    System.out.println(f.fibRecursive(4));
    System.out.println(f.fibMemoization(4));
  }
}
