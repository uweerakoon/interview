package leetcode.easy;

public class PlusOne {
  // https://leetcode.com/problems/plus-one/
  public int[] plusOne(int[] digits) {
    return addOne(digits, digits.length-1);
  }

  public int[] addOne(int[] digits, int index){
    if(index == 0 && digits[index] < 9){
      digits[index] +=1;
      return digits;
    }else if(index == 0 && digits[index] == 9){
      digits[index] = 0;
      int[] temp = new int[digits.length+1];
      temp[0] = 1;
      return temp;
    }else if(digits[index] == 9){
      digits[index] = 0;
      return addOne(digits, index-1);
    }else{
      digits[index] +=1;
      return digits;
    }
  }
}
