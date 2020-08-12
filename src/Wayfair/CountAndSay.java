package Wayfair;

public class CountAndSay {

  // https://leetcode.com/problems/count-and-say/
  public String countAndSay(int n) {
    if (n == 1)
      return "1";
    String str = countAndSay(n - 1);
    int count = 1;
    StringBuilder ans = new StringBuilder();
    int i;
    for (i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1))
        count++;
      else {
        ans = ans.append(count).append(str.charAt(i - 1));
        count = 1;
      }
    }
    ans = ans.append(count).append(str.charAt(i - 1));
    return ans.toString();
  }
}
