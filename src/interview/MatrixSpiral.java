package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixSpiral {
 // matrix(4)
  // [[1,2,3,4],
  //  [12,13,14,5],
  //  [11,16,15,6],
  //  [10,9,8,7]]
  
  public List<List<Integer>> getMatrixSpiral(int n) {
    List<List<Integer>> output = new ArrayList<>();
    int[][] matrix = new int[n][n];
//    for(int i=0; i<n; i++) {
//      List<Integer> row = new ArrayList<>();
//      for(int j=0; j<n; j++) {
//        row.add(null);
//      }
//      output.add(row);
//    }
    
    int counter = 1, startColumn = 0, endColumn = n-1, startRow = 0, endRow = n-1;
    while(startColumn <= endColumn && startRow <= endRow) {
      // top row
      for(int i=startColumn; i<= endColumn; i++) {
        matrix[startRow][i] = counter++;
      }
      startRow++;
      // last column
      for(int i=startRow; i<= endRow; i++) {
        matrix[i][endColumn] = counter++;
      }
      endColumn--;
      // bottom row
      for(int i=endColumn; i >= startColumn; i--) {
        matrix[endRow][i] = counter++;
      }
      endRow--;
      // first column
      for(int i=endRow; i >= startRow; i--) {
        matrix[i][startColumn] = counter++;
      }
      startColumn++;
    }
    for(int i=0; i<n; i++) {
      List<Integer> row = Arrays.stream(matrix[i])
                            .boxed()
                            .collect(Collectors.toList());
      output.add(row);
    }
    return output;
  }
  
  public static <T> List<T> convertArrayListList(T array[]) {
    List<T> list = Arrays.asList(array);
    return list;
  }
  
  public static void main(String[] args) {
    MatrixSpiral m = new MatrixSpiral();
    List<List<Integer>> output = m.getMatrixSpiral(4);
    for(List<Integer> row : output) {
      System.out.println(row);
    }
  }
}
