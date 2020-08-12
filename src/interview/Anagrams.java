package interview;

import java.util.Arrays;

public class Anagrams {

  private static final int NO_OF_CHARS = 256;
  // O(n)
  public boolean histogramAnagram(String str1, String str2) {
    if(str1 == null || str1.isEmpty()
        || str2 == null || str2.isEmpty())
      return false;
    str1 = str1.replaceAll("[^a-zA-Z0-9\\s+]", "");
    str2 = str2.replaceAll("[^a-zA-Z0-9]\\s+", "");
    if(str1.length() != str2.length())
      return false;
    int count1[] = new int[NO_OF_CHARS];
    Arrays.fill(count1, 0);
    int count2[] = new int[NO_OF_CHARS];
    Arrays.fill(count2, 0);
    char[] arr1 = str1.toLowerCase().toCharArray();
    char[] arr2 = str2.toLowerCase().toCharArray();
    for(int i =0; i < str1.length() && i <str2.length(); i++) {
      count1[arr1[i]]++;
      count2[arr2[i]]++;
    }
    
    for(int i = 0; i < NO_OF_CHARS; i++) 
      if (count1[i] != count2[i])
        return false;
    return true;
  }
  
  // Time O(n) space O(1)
  public boolean xorAnagram(String str1, String str2) {
    if(str1 == null || str1.isEmpty()
        || str2 == null || str2.isEmpty())
      return false;
    str1 = str1.replaceAll("[^a-zA-Z0-9\\s+]", "");
    str2 = str2.replaceAll("[^a-zA-Z0-9]\\s+", "");
    if(str1.length() != str2.length())
      return false;
    int value = 0; // TxT=F FxF=F TxF=FxT=T 1x1=0 0x0=0
    for(int i=0; i<str1.length(); i++) {
      value ^= str1.charAt(i);
      value ^= str2.charAt(i);
    }
    return value == 0;
  }
  //O(n Log n)
  public boolean anagram(String str1, String str2) {
    if(str1 == null || str1.isEmpty()
        || str2 == null || str2.isEmpty())
      return false;
    str1 = str1.replaceAll("[^a-zA-Z0-9\\s+]", "");
    str2 = str2.replaceAll("[^a-zA-Z0-9]\\s+", "");
    if(str1.length() != str2.length())
      return false;
    char[] arr1 = str1.toLowerCase().toCharArray();
    char[] arr2 = str2.toLowerCase().toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    for(int i = 0; i < arr1.length; i++) 
      if(arr1[i] != arr2[i])
        return false;
    return true;
  }
  
  public static void main(String[] args) {
    Anagrams anagrams = new Anagrams();
    System.out.println(anagrams.anagram("rail safety", "fairy tales"));
    System.out.println(anagrams.anagram("RAIL! SAFETY!", "fairy tales"));
    System.out.println(anagrams.anagram("Hi there", "Bye There")+"\n");
    
    System.out.println(anagrams.histogramAnagram("rail safety", "fairy tales"));
    System.out.println(anagrams.histogramAnagram("RAIL! SAFETY!", "fairy tales"));
    System.out.println(anagrams.histogramAnagram("Hi there", "Bye There")+"\n");
    
    System.out.println(anagrams.xorAnagram("rail safety", "fairy tales"));
    System.out.println(anagrams.xorAnagram("RAIL! SAFETY!", "fairy tales"));
    System.out.println(anagrams.xorAnagram("Hi there", "Bye There")+"\n");
  }
}
