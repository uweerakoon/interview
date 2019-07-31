package interview;

import java.util.Arrays;

public class ArrayChunks {

  public int[][] chunk(int[] array, int size) {
    if(size <= 0)
      return null;
    int rest = array.length % size; // chunk evenly or not
    int chunks = array.length / size + (rest > 0 ? 1 : 0); // total chunks
    int[][] arrays = new int[chunks][];
    for(int i = 0; i < (rest > 0 ? chunks - 1 : chunks); i++)
      arrays[i] = Arrays.copyOfRange(array, i*size, i*size+size);
    if(rest > 0)
      arrays[chunks-1] = Arrays.copyOfRange(array, (chunks-1)*size, (chunks-1)*size+rest);
    return arrays;
  }
  
  public static void main(String[] args) {
    ArrayChunks arrayChunks = new ArrayChunks();
    int[] intArray = {1,2,3,4};
    System.out.println(Arrays.deepToString(arrayChunks.chunk(intArray,2)));
    intArray = new int[]{1,2,3,4,5};
    System.out.println(Arrays.deepToString(arrayChunks.chunk(intArray,2)));
    intArray = new int[]{1,2,3,4,5,6,7,8};
    System.out.println(Arrays.deepToString(arrayChunks.chunk(intArray,3)));
    intArray = new int[]{1,2,3,4,5};
    System.out.println(Arrays.deepToString(arrayChunks.chunk(intArray,4)));
    intArray = new int[]{1,2,3,4,5};
    System.out.println(Arrays.deepToString(arrayChunks.chunk(intArray,10)));
  }
}
