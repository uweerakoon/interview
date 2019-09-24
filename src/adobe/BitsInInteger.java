package adobe;

public class BitsInInteger {

//  Input : n = 6
//      Output : 2
//      Binary representation of 6 is 110 and has 2 set bits
//
//      Input : n = 13
//      Output : 3
//      Binary representation of 13 is 1101 and has 3 set bits
  
  public int getBits(int n) {
    int noBits = 0;
    while(n != 0) {
      noBits += (n & 1);
      n = n >> 1;
    }
    return noBits;
  }
  
//  Input : 111
//  Output : 7
//
//  Input : 1010
//  Output : 10
//
//  Input: 100001
//  Output: 33
  
  public int getInteger(int n) {
    int factor = 1;
    int val = 0;
    while(n != 0) {
      val += ((n%10)*factor);
      factor *= 2;
      n /= 10;
    }
    return val;
  }
  
  public int getInteger(String binaryNumber) {
    return Integer.parseInt(binaryNumber, 2);
  }
  
  public static void main(String[] args) {
    BitsInInteger bitsInInteger = new BitsInInteger();
    System.out.println("# Bits: "+bitsInInteger.getBits(13));
    System.out.println("# Bits: "+bitsInInteger.getBits(13));
    System.out.println("Integer Val: "+bitsInInteger.getInteger(111));
    System.out.println("Integer Val: "+bitsInInteger.getInteger(1010));
    System.out.println("Integer Val: "+bitsInInteger.getInteger(100001));
    System.out.println("Integer Val By String: "+bitsInInteger.getInteger("100001"));
  }
}
