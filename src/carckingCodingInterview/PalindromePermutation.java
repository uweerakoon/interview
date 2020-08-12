package carckingCodingInterview;

public class PalindromePermutation {

  public static void main(String[] args) {
    PalindromePermutation p = new PalindromePermutation();
    System.out.println(p.permutation("Tact Coa", "", false));
  }

  public boolean permutation(String orig, String result, boolean isPalindrome) {
    if (orig.contains(" ")) {
      orig = orig.replaceAll("\\s+", "");
    }
    if (orig.isEmpty()) {
      return isPalindrome(result);
    }

    for (int i = 0; i < orig.length(); i++) {
      if (isPalindrome) {
        return true;
      }
      isPalindrome = permutation(orig.substring(0, i) + orig.substring(i + 1),
          result + orig.charAt(i), false);
    }

    return isPalindrome;
  }

  private boolean isPalindrome(String result) {
    result = result.toLowerCase();
    int i = 0, j = result.length() - 1;
    while (i < j) {
      if (result.charAt(i++) != result.charAt(j--)) {
        return false;
      }
    }
    return true;
  }
}
