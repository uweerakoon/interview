package interview;

import java.util.function.IntPredicate;

public class Vowels {
  
  public int getNoVowelsIterate(String str) {  
    int count = 0;
    String checker = "aeiou";
    for(char c : str.toLowerCase().toCharArray()) {
      if(checker.indexOf(c) > -1)
        count++;
    }
    return count;
  }
  
  private static final IntPredicate vowelPredicate = new IntPredicate() {
    @Override
    public boolean test(int value) {
      return value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u';
    }
  };
  
  public long getNoVowelsPredicate(String str) {
    return str.toLowerCase().chars().filter(vowelPredicate).count();
  }
  
  public static void main(String[] args) {
    Vowels vowels = new Vowels();
    System.out.println(vowels.getNoVowelsIterate("udara weerakoon"));
    System.out.println(vowels.getNoVowelsPredicate("udara weerakoon"));
  }
}
