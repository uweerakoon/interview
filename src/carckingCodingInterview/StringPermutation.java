package carckingCodingInterview;

public class StringPermutation {
  public static void main(String[] args) {
    StringPermutation.permutation("uda", "");
  }

  public static void permutation(String str, String pre) {
    if (str.length() == 0) {
      System.out.println(pre);
    }
    else {
      for (int i = 0; i < str.length(); i++) {
        String rem = str.substring(0, i) + str.substring(i+1);
        permutation(rem, pre+str.charAt(i));
      }
    }
  }
}
