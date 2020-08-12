package Wayfair;
// https://leetcode.com/problems/maximum-subarray/solution/
public class MaximumSubarray {

  // Divide and Conquer
//  Time complexity : O(NlogN). Let's compute the solution with the help of master theorem T(N)=aT(b/N)+Θ(N^d). 
  // The equation represents dividing the problem up into a subproblems of size N/b in Θ(N^d) time. Here one divides the problem in two subproblemes a = 2, the size of each subproblem (to compute left and right subtree) is a half of initial problem b = 2, and all this happens in a O(N) time d = 1. That means that \log_b(a) = dlog 
//   (a)=d and hence we're dealing with case 2 that means \mathcal{O}(N^{\log_b(a)} \log N) = \mathcal{O}(N \log N)O(N 
  //log 
  //b
//   (a)
  // logN)=O(NlogN) time complexity.
//  Space complexity : O(logN) to keep the recursion stack. 
  public int crossSum(int[] nums, int left, int right, int p) {
    if (left == right) return nums[left];

    int leftSubsum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i = p; i > left - 1; --i) {
      currSum += nums[i];
      leftSubsum = Math.max(leftSubsum, currSum);
    }

    int rightSubsum = Integer.MIN_VALUE;
    currSum = 0;
    for(int i = p + 1; i < right + 1; ++i) {
      currSum += nums[i];
      rightSubsum = Math.max(rightSubsum, currSum);
    }

    return leftSubsum + rightSubsum;
  }

  public int helper(int[] nums, int left, int right) {
    if (left == right) return nums[left];

    int p = (left + right) / 2;

    int leftSum = helper(nums, left, p);
    int rightSum = helper(nums, p + 1, right);
    int crossSum = crossSum(nums, left, right, p);

    return Math.max(Math.max(leftSum, rightSum), crossSum);
  }

  public int maxSubArrayDC(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }
  
  // Greedy
  // Time complexity : O(N) since it's one pass along the array.
  // Space complexity : O(1), since it's a constant space solution. 
  public int maxSubArrayGreedy(int[] nums) {
    int n = nums.length;
    int currSum = nums[0], maxSum = nums[0];

    for(int i = 1; i < n; ++i) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
  
  // Dynamic Programming (Kadane's algorithm)
  // Time complexity : O(N) since it's one pass along the array.
  // Space complexity : O(1), since it's a constant space solution.
  public int maxSubArrayDP(int[] nums) {
    int n = nums.length, maxSum = nums[0];
    for(int i = 1; i < n; ++i) {
      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
      maxSum = Math.max(nums[i], maxSum);
    }
    return maxSum;
  }
}
