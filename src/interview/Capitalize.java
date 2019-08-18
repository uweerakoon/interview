package interview;

public class Capitalize {

  public String capitalize(String str) {
    if(str == null || str.isEmpty()) {
      return null;
    }
    char[] chars = str.toCharArray();
    for(int i=0; i<chars.length; i++) {
      // first letter and first work after the space
      if(i==0 && chars[i] != ' '
          || chars[i] != ' ' && chars[i-1] == ' ') {
        if(chars[i] >= 'a' && chars[i] <= 'z') // if simple
          chars[i] = (char)(chars[i] - 'a' + 'A');
      }
      else if(chars[i] >= 'A' && chars[i] <= 'Z') // others are capital
        chars[i] = (char) (chars[i] - 'A' + 'a');
    }
    return new String(chars);
  }
  
  public String uppercaseCapitalize(String str) {
    if(str == null || str.isEmpty()) {
      return null;
    }
    StringBuffer sb = new StringBuffer();
    char ch = ' ';
    for(int i=0; i<str.length(); i++) {
      if(ch == ' ' && str.charAt(i) != ' ')
        sb.append(Character.toUpperCase(str.charAt(i)));
      else 
        sb.append(str.charAt(i));
      ch = str.charAt(i); // ch goes one behind
    }
    return sb.toString().trim();
  }
  
  public static void main(String[] args) {
    Capitalize capitalize = new Capitalize();
    System.out.println(capitalize.capitalize("a short sentence"));
    System.out.println(capitalize.capitalize("a lazy fox"));
    System.out.println(capitalize.capitalize("look, it is working!")+"\n");
    
    System.out.println(capitalize.uppercaseCapitalize("a short sentence"));
    System.out.println(capitalize.uppercaseCapitalize("a lazy fox"));
    System.out.println(capitalize.uppercaseCapitalize("look, it is working!")+"\n");
  }
}
