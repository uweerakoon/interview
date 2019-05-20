package interview;

import java.util.Scanner;

public class StringReversal {

  public static void main(String[] args)
  {
    StringReversal sr = new StringReversal();
    sr.reverseByStringBuilder("udara");
  }
  
  public String reverseByStringBuilder(String input) {
    /*System.out.println("Enter string to reverse:");
    
    Scanner read = new Scanner(System.in);
    String str = read.nextLine();*/
    
    StringBuilder sb = new StringBuilder(input);
    return sb.reverse().toString();
    
    /*System.out.println("Reversed string is:");
    System.out.println(sb.reverse().toString());
    read.close();*/
  }
  
  public String reverseByDecrementSB(String input) {
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = input.length() - 1; i >= 0; i--)
    {
        sb.append(input.charAt(i));
    }
    return sb.toString();
  }
  
  public void reverseByString() {
    System.out.println("Enter string to reverse:");
    
    Scanner read = new Scanner(System.in);
    String str = read.nextLine();
    String reverse = "";
    
    
    for(int i = str.length() - 1; i >= 0; i--)
    {
        reverse = reverse + str.charAt(i);
    }
    
    System.out.println("Reversed string is:");
    System.out.println(reverse);
    read.close();
  }
}
