package divvy;

import java.util.Arrays;

public class GearingUp {
  // https://www.quora.com/How-do-you-solve-Googles-foo-bar-coding-problem-Gearing-Up-for-Destruction

//  public int[] answer(int[] pegs) {
//    // do the inductive math
//    int a = pegs[0];
//    int flip = -1;
//    for(int peg: pegs) {
//      a += 2 * peg * flip;
//      flip *= -1;
//    }
//    a += pegs[pegs.length-1] * flip;
//    a *= 2;
//    int b = (pegs.length%2==0) ? 3 : 1;
//
//    // reduce
//    if(a%b==0) {
//      a /= b;
//      b = 1;
//    }
//
//    // reject bad values
//    float prevR = ((float)a) / ((float)b);
//    for(int i = 0; i < pegs.length - 2; i++) {
//      int width = pegs[i+1] - pegs[i];
//      if(prevR < 0 || prevR > (width-1)) return new int[] {-1, -1};
//      prevR = width - prevR;
//    }
//
//    return new int[] {a, b};
//  }
  
  public int[] answer(int[] pegs) {
    // iteratively get the pair value alternating the sum
    int sign = pegs.length%2==0 ? -1 : 1;
    int a = 2 * altSum(sign, pegs.length-1, pegs);
    int b = (pegs.length%2==0) ? 3 : 1;

    // reduce
    if(a%b == 0 && b != 1) {
      a /= b;
      b = 1;
    }

    // reject bad values
    float prevR = ((float)a) / ((float)b);
    for(int i = 0; i < pegs.length - 2; i++) {
      int width = pegs[i+1] - pegs[i];
      if(prevR < 0 || prevR > (width-1)) 
        return new int[] {-1, -1};
      prevR = width - prevR;
    }

    return new int[] {a, b};
  }
  
  public int altSum(int sign, int index, int[] array) {
    if(index <= 0)
      return 0;
    return sign * array[index-1] + -1 * sign * array[index] 
        + altSum(sign*-1, index-1, array);
  }
  
  public static void main(String[] args) {
    GearingUp gearingUp = new GearingUp();
    System.out.println(Arrays.toString(gearingUp.answer(new int[]{4,8})));
    System.out.println(Arrays.toString(gearingUp.answer(new int[]{4,30,50})));
    System.out.println(Arrays.toString(gearingUp.answer(new int[]{1,504,1124})));
//    int[] array = new int[]{1,2,3,4,5};
//    System.out.println(gearingUp.altSum(1, array.length-1, array));
  }
}
