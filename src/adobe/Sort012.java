package adobe;

import java.util.Arrays;

public class Sort012 {

//  Input: {0, 1, 2, 0, 1, 2}
//  Output: {0, 0, 1, 1, 2, 2}
//
//  Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
//  Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
  // Dutch National Problem http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
  public void sort012(int[] array) {
    int lo = 0, mid = 0, hi = array.length - 1;
    int temp = 0;
    while(mid <= hi) {
      switch (array[mid]) {
        case 0: 
          temp = array[lo];
          array[lo] = array[mid];
          array[mid] = temp;
          lo ++;
          mid ++;
          break;
        case 1:
          mid++;
          break;
        case 2: 
          temp = array[hi];
          array[hi] = array[mid];
          array[mid] = temp;
          hi--;
          break;
      }
    }
  }
  
  public static void main(String[] args) {
    int array[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 }; 
    Sort012 sort012 = new Sort012();
    sort012.sort012(array);
    System.out.println("sorted array: "+Arrays.toString(array));
  }
}
