package commandalkine;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacter {

  public Character getUniqueCharacter(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(map.containsKey(c))
        map.put(c, map.get(c)+1);
      else 
        map.put(c, 1);
    }
    
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(map.get(c) == 1)
        return c;
    }
    return null;
  }
 
  
  public static void main(String[] args) {
    UniqueCharacter uc = new UniqueCharacter();
    System.out.println(uc.getUniqueCharacter("tooct"));
    
    int x1 = 1, y1 = 2, x2 = 3, y2 = 4, x3 = 2, y3 = 1, x4 = 4, y4 = 3;
    double area = Math.abs(Math.max(x1, x3) - Math.min(x2, x4)) * Math.abs(Math.max(y1, y3) - Math.min(y2, y4));
    System.out.println(area);
  }
}
