package divvy;

import java.math.BigDecimal;

public class StoreLocation {
// https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function
//  public int answer(int x, int y) {
//    if(x <= 0 || y <= 0)
//      return 0;
//    if(x == 1 && y == 1)
//      return 1;
//    int newX = x-1, newY = y+1;
//    if(newX == 0)
//      newX = x+y-2;
//    if(newY == x+y)
//      newY = 1;
//    return answer(newX, newY) + 1;
//  }
  
//  public int answer(int x, int y) {
//    if(x <= 0 || y <= 0)
//      return 0;
//    if(x == 1 && y == 1)
//      return 1;
//    int counter = 1;
//    if(x == 1) {
//      x = 1;
//      y--;
//      counter = y;
//    }
//    else {
//      x--;
//      y++;
//    }
//    return answer(x, y) + counter;
//  }
  
  BigDecimal one = BigDecimal.valueOf(1);
  BigDecimal two = BigDecimal.valueOf(2);
  public long answer(long x, long y) {
    if(x <= 0 || y <= 0)
      return 0;
    if(x == 1) {
      BigDecimal bigY = BigDecimal.valueOf(y);
      return bigY.subtract(one).multiply(bigY).divide(two).add(one).longValue();
    }
    return answer(1, x+y-1) + (x-1);
  }
  
  
  public static void main(String[] args) {
    StoreLocation storeLocation = new StoreLocation();
    System.out.println("(5) 2,2: "+storeLocation.answer(2, 2));
    System.out.println("(12) 2,4: "+storeLocation.answer(2, 4));
    System.out.println("(10) 4,1: "+storeLocation.answer(4, 1));
    System.out.println("(14) 4,2: "+storeLocation.answer(4, 2));
//    System.out.println("(actual = 672447169, expected = 20000000001 - 9 0's) 100000,100000: "+storeLocation.answer(100000, 100000)
//      +" google = 19999800001 (less than 200000 of actual val)");
//    System.out.println("5,1: "+storeLocation.answer(5, 1));
//    BigDecimal a = BigDecimal.valueOf(199998);
//    BigDecimal b = BigDecimal.valueOf(199999);
//    System.out.println(a.multiply(b));
  }
}
