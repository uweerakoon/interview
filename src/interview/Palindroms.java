package interview;

import java.util.stream.IntStream;

public class Palindroms {

  public boolean isPalindrom(String text) {
    String cleanStr = text.replaceAll("\\s+", "");
    int forward = 0, backward = cleanStr.length()-1;
    while(backward > forward) 
      if(cleanStr.charAt(forward++) != cleanStr.charAt(backward--)) 
        return false;
    return true;
  }

  public boolean isPalindrom(String cleanStr, int forward, int backward) {
    if(forward == backward || forward == (backward + 1))
      return true;
    if(cleanStr.charAt(forward) != cleanStr.charAt(backward))
      return false;
    if(forward < backward + 1)
      return isPalindrom(cleanStr, forward+1, backward-1);
    return false;
  }

  public boolean isPalindromStringBuilder(String cleanStr) {
    StringBuilder sb = new StringBuilder(cleanStr);
    return  sb.reverse().toString().equals(cleanStr);
  }

  public boolean isPalindromStringBuffer(String cleanStr) {
    StringBuffer sb = new StringBuffer(cleanStr);
    return  sb.reverse().toString().equals(cleanStr);
  }

  public boolean isPalindromIntStream(String cleanStr) {
    return IntStream.range(0, cleanStr.length() / 2)
        .noneMatch(i -> cleanStr.charAt(i) != cleanStr.charAt(cleanStr.length()-i-1));
  }
  
  // Time complexity O(log10(n)). We divided the input by 10 for every iteration, so the time complexity is O(log10(n))
  // Space complexity : O(1).
  public boolean IsPalindrome(int x) {
    if(x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int revertedNumber = 0;
    while(x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNumber || x == revertedNumber/10;
  }

  public static void main(String[] args) {
    Palindroms palindroms = new Palindroms();
    String strGood = "abba";
    String strBad = "abcde";
    System.out.println("isPalindrom: "+palindroms.isPalindrom(strGood+" "));
    System.out.println("isPalindrom: "+palindroms.isPalindrom(strBad+" "));
    System.out.println("isPalindromStringBuilder: "+palindroms.isPalindromStringBuilder(strGood));
    System.out.println("isPalindromStringBuilder: "+palindroms.isPalindromStringBuilder(strBad));
    System.out.println("isPalindromStringBuffer: "+palindroms.isPalindromStringBuffer(strGood));
    System.out.println("isPalindromStringBuffer: "+palindroms.isPalindromStringBuffer(strBad));
    System.out.println("isPalindromIntStream: "+palindroms.isPalindromIntStream(strGood));
    System.out.println("isPalindromIntStream: "+palindroms.isPalindromIntStream(strBad));
    System.out.println("isPalindrom Recurssion: "+palindroms.isPalindrom(strGood, 0, strGood.length()-1));
    System.out.println("isPalindrom Recurssion: "+palindroms.isPalindrom(strBad, 0, strBad.length()-1));
  }
}
