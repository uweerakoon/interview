package adobe;

import java.util.Arrays;

public class WaterDrop {

  /*Input: arr[]   = {2, 0, 2}
  Output: 2
  Structure is like below
  | |
  |_|
  We can trap 2 units of water in the middle gap.

  Input: arr[]   = {3, 0, 0, 2, 0, 4}
  Output: 10
  Structure is like below
       |
  |    |
  |  | |
  |__|_| 
  We can trap "3*2 units" of water between 3 an 2,
  "1 unit" on top of bar 2 and "3 units" between 2 
  and 4.  See below diagram also.

  Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
  Output: 6
         | 
     |   || |
  _|_||_||||||
  Trap "1 unit" between first 1 and 2, "4 units" between
  first 2 and 3 and "1 unit" between second last 1 and last 2*/ 
  // O(n) Auxiliary Space: O(n)
  public int findWater(int[] container) {
    // left[i] contains height of tallest bar to the 
    // left of i'th bar including itself 
    int left[] = new int[container.length];
    
    // Right [i] contains height of tallest bar to 
    // the right of ith bar including itself 
    int right[] = new int[container.length];
    
    // Initialize result 
    int water = 0; 
    
    // Fill left array 
    left[0] = container[0]; 
    for (int i = 1; i < container.length; i++) 
       left[i] = Math.max(left[i-1], container[i]);
    
    // Fill right array
    right[right.length - 1] = container[container.length - 1];
    for(int i = right.length-2; i >= 0; i--) 
      right[i] = Math.max(right[i+1], container[i]);
    
    // Calculate the accumulated water element by element 
    // consider the amount of water on i'th bar, the 
    // amount of water accumulated on this particular 
    // bar will be equal to min(left[i], right[i]) - arr[i] .
    for(int i=0; i<container.length; i++) {
      water += Math.min(left[i], right[i]) - container[i];
    }
    return water;
  }
  
  //O(n) Auxiliary Space: O(1)
  public int findWaterVariable(int[] container) {
    int water = 0, left_max = 0, right_max = 0;
    int lo = 0, hi = container.length - 1;
    while(lo <= hi) {
      if(container[lo] < container[hi]) {
        if(container[lo] > left_max)
          left_max = container[lo];
        else
          water += left_max - container[lo];
        lo++;
      } else {
        if(container[hi] > right_max)
          right_max = container[hi];
        else 
          water += right_max - container[hi];
        hi--;
      }
    }
    return water;
  }
  
  public static void main(String[] args) {
    WaterDrop waterDrop = new WaterDrop();
    int container[] = new int[]{2, 0, 2}; 
    System.out.println("Water of "+Arrays.toString(container)+" is: "+waterDrop.findWater(container));
    container = new int[]{3, 0, 0, 2, 0, 4};
    System.out.println("Water of "+Arrays.toString(container)+" is: "+waterDrop.findWater(container));
    container = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println("Water of "+Arrays.toString(container)+" is: "+waterDrop.findWater(container));
    container = new int[]{2, 0, 2}; 
    System.out.println("Water of "+Arrays.toString(container)+" is: "+waterDrop.findWaterVariable(container));
    container = new int[]{3, 0, 0, 2, 0, 4};
    System.out.println("Water of "+Arrays.toString(container)+" is: "+waterDrop.findWaterVariable(container));
    container = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println("Water of "+Arrays.toString(container)+" is: "+waterDrop.findWaterVariable(container));
  }
}
