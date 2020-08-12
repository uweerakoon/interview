package goldmansachs;

public class ClimbingStairs {

//  F{0}=0,F{1}=1  F{n}=F_{n-1}+F_{n-2}
  
  // Fibonacci Formula
  //  Time complexity : O(logn). pow method takes logn time.
  //  Space complexity : O(1). Constant space is used.
  public int climbStairsFF(int n) {
    double sqrt5=Math.sqrt(5);
    double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
    return (int)(fibn/sqrt5);
  }

  // Dynamic Programming
  //  Time complexity : O(n). Single loop upto nn.
  //  Space complexity : O(n). dpdp array of size nn is used. 
  public int climbStairsDP(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // Recursion with Memoization
//  Time complexity : O(n). Size of recursion tree can go upto nn.
//  Space complexity : O(n). The depth of recursion tree can go upto nn. 
  public int climbStairs(int n) {
    int memo[] = new int[n + 1];
    return climb_Stairs(0, n, memo);
  }
  
  public int climb_Stairs(int i, int n, int memo[]) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }
    memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    return memo[i];
  }
}
