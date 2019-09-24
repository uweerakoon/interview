package interview;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Sorting {

  public List<Integer> bubbleSort(List<Integer> arr) {
    for(int i=0; i < arr.size(); i++) {
      for(int j=0; j < (arr.size()-i-1); j++) {
        if(arr.get(j) > arr.get(j+1)) {
          int lesser = arr.get(j);
          arr.set(j, arr.get(j+1));
          arr.set(j+1, lesser);
        }
      }
    }
    return arr;
  }
  
  public List<Integer> selectionSort(List<Integer> arr) {
    for(int i=0; i<arr.size(); i++) {
      int indexOfMin = i;
      for(int j = i+1; j <arr.size(); j++) {
        if(arr.get(indexOfMin) > arr.get(j))
          indexOfMin = j;
      }
      if(i != indexOfMin) {
        int lesser = arr.get(indexOfMin);
        arr.set(indexOfMin, arr.get(i));
        arr.set(i, lesser);
      }
    }
    return arr;
  }
  
  public List<Integer> mergeSort(List<Integer> arr) {
    if(arr.size() == 1) {
      return arr;
    }
    int half = arr.size() / 2;
    List<Integer> left = new ArrayList<>();
    left.addAll(arr.subList(0, half));
    List<Integer> right = new ArrayList<>();
    right.addAll(arr.subList(half, arr.size()));
    
    return merge(mergeSort(left), mergeSort(right));
  }
  
  public List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> results = new LinkedList<>();
    while(!left.isEmpty() && !right.isEmpty()) {
      if(left.get(0) < right.get(0)) {
        results.add(left.remove(0));
      } else {
        results.add(right.remove(0));
      }
    }
    if(!left.isEmpty()) {
      results.addAll(left);
    }
    if(!right.isEmpty()) {
      results.addAll(right);
    }
    return results;
  }
  
  public static void main(String[] args) {
    List<Integer> arr = new LinkedList<>();
    arr.add(10);
    arr.add(-30);
    arr.add(97);
    arr.add(0);
    arr.add(5);
    Sorting sorting = new Sorting();
//    System.out.println(sorting.bubbleSort(arr));
//    System.out.println(sorting.selectionSort(arr));
    System.out.println(sorting.mergeSort(arr));
    
  }
}
