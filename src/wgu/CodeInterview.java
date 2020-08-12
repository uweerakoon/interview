package wgu;

import java.util.HashSet;
import java.util.Set;

public class CodeInterview {
 // Abeedrffg123!!a !bs&& = A5g123!!a0a !b0s&&
  public String inbetweenCharCounter(String input) {
    char c = input.charAt(0);
    int count = 0;
    Set<Character> chars = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for(int i=1; i < input.length(); i++) {
      if(!isAlphabet(c)) {
        sb.append(c);
        c = input.charAt(i);
        continue;
      }
      char nextChar = input.charAt(i);
      if(!isAlphabet(nextChar)) {
        if(count == 0) {
          sb.append(c).append('0').append(c);
        } else {
          sb.append(count-1).append(c);
          count = 0;
          chars.clear();
        }
      }
      else {
        if(count == 0) {
          sb.append(c);
          count++;
        } else {
          if(!chars.contains(c)) {
            chars.add(c);
            count++;
          }
        }
      }
      c = input.charAt(i);
    }
    
    String output = !isAlphabet(c)
                      ? sb.append(c).toString()
                      : count == 0
                        ? sb.append(c).append('0').append(c).toString()
                        : sb.append(count-1).append(c).toString();    
    
    return output;
  }
  
  private boolean isAlphabet(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
  
  public static void main(String[] args) {
    System.out.println("a: "+(int)'a'+" z: "+(int)'z'+" A: "+(int)'A'+" Z: "+(int)'Z');
    CodeInterview c = new CodeInterview();
    System.out.println("input A output: "+c.inbetweenCharCounter("A"));
    System.out.println("input: Abeedrffg123!!a !bs&&aberrtts output: "+c.inbetweenCharCounter("Abeedrffg123!!a !bs&&aberrtts"));
  }
}
