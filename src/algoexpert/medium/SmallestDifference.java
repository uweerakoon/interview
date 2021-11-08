package algoexpert.medium;

import java.util.Arrays;

public class SmallestDifference {
  // Time complexity is O(n log (n) + m log (m)) because the dominant factor is the sorting
  // Space complexity is O(1) because the space is a constant value
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Sorts the arrays O(n log (n) + m log (m))
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    // set up two pointers for each one
    int indexOne = 0;
    int indexTwo = 0;
    int smallestDifference = Integer.MAX_VALUE;
    int currentDifference;
    int[] smallestPair = null;
    // check index are valid before entering to the while loop
    // Time complexity of the while loop is O(n + m)
    while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
      int firstNum = arrayOne[indexOne];
      int secondNum = arrayTwo[indexTwo];
      // if first number is less move the index one
      if (firstNum < secondNum) {
        currentDifference = secondNum - firstNum;
        indexOne++;
      }
      // if the second number is less move the second index
      else if (secondNum < firstNum) {
        currentDifference = firstNum - secondNum;
        indexTwo++;
      }
      // if both numbers are same then that is the answer
      else {
        return new int[] {firstNum, secondNum};
      }
      // update the distance and the corresponding values if the smallest distance is more
      // than the current calculated value
      if (smallestDifference > currentDifference) {
        smallestDifference = currentDifference;
        smallestPair = new int[] {firstNum, secondNum};
      }
    }
    return smallestPair;
  }

  public static void main(String[] args) {
    /*
    Give two arrays find the two numbers (each from the array)
    that has the smallest difference possible
    [28, 26] difference is 2 which is the smallest
     */
    final int[] arrayOne = {- 1, 5, 10, 20, 28, 3};
    final int[] arrayTwo = {26, 134, 135, 15, 17};
    final int[] smallestDifference = smallestDifference(arrayOne, arrayTwo);
    System.out.println(Arrays.toString(smallestDifference));
  }
}
