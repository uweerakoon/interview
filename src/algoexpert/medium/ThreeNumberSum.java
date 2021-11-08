package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
  // Time: O(n^2)   -- O(n log n) is ignored because O(n^2) is higher
  // Space: O(n)  because the result can store the whole array
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    final List<Integer[]> result = new ArrayList<>();
    // O(n log n)
    Arrays.sort(array); // {-8, -6, 1, 2, 3, 5, 6, 12}
    // O (n^2)
    for (int pointer = 0; pointer < array.length - 2; pointer++) { // looking for triplet so goes to the last  - 2
      int leftPointer = pointer + 1;
      int rightPointer = array.length - 1;
      while (leftPointer < rightPointer) { // no need to check the overlap; array has distinguished values
        int sum = array[pointer] + array[leftPointer] + array[rightPointer];
        if(sum == targetSum) {
          // move left make the sum bigger; move right make the sum smaller; moving both can make the sum even
          result.add(new Integer[]{array[pointer], array[leftPointer], array[rightPointer]});
          rightPointer--;
          leftPointer++;
        }
        if (sum > targetSum) {
          // make the sum smaller
          rightPointer--;
        }
        else if (sum < targetSum) { // need to check otherwise adjustments after the equal can mess things up
          // make the sum bigger
          leftPointer++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    /*
    Find the three numbers when they add together to the target sum
    if there is more than one triplet then arrange to an array of triplets
    all need to be sorted: triplet and the array of triplets
     */
    final int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
    final int targetSum = 0;
    final List<Integer[]> result = ThreeNumberSum.threeNumberSum(array, targetSum);
    result.forEach(s -> System.out.println(Arrays.toString(s)));
  }

}
