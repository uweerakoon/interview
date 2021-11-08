package algoexpert.medium;

import java.util.List;

import com.google.common.collect.Lists;

/*
 array = [2, 1, 2, 2, 2, 3, 4, 2]
 toMove = 2
 output = [1, 3, 4, 2, 2, 2, 2, 2]  order of 1, 3, 4 does not matter

  We can use this in linear time because we have to traverse
  through the array
  We are going to use the quick sort method where swapping is
  used.
  use two pointers: i and j where i comes from start and j comes from end
  j is looking for any value that is not equal to give number and stop there
    in this case we have to maintain the i<j condition
  i is looking for any value that is equal to the given number
  once i have a given number and j does not have a number
    swap the items
    increment i
 */
public class MoveElementToEnd {
  public static List<Integer> moveElementtoEnd(List<Integer> array, int toMove) {
    int i = 0, j = array.size() - 1;
    while(i < j) {
      while(i < j && array.get(j) == toMove) {
        j--;
      }
      if(array.get(i) == toMove) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
      }
      i++;
    }
    return array;
  }

  public static void main(String[] args) {
    List<Integer> array = Lists.newArrayList(2, 1, 2, 2, 2, 3, 4, 2);
    System.out.println(moveElementtoEnd(array, 2));
  }
}
