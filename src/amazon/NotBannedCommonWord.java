package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NotBannedCommonWord {

  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> set = new HashSet<>();
    for (String b : banned) set.add (b);

    Map<String, Integer> map = new HashMap<>();
    String ans = ""; int count = 0;
    for (String s : paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")) {
      s = s.trim();
      if (s.length() == 0 || set.contains (s)) continue;
      map.put(s, map.getOrDefault(s, 0) + 1);
      if (count < map.get (s)) { count = map.get (s); ans = s; }
    }
    return ans;
  }
  
  public static void main(String[] args) {
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};
    NotBannedCommonWord notBannedCommonWord = new NotBannedCommonWord();
    System.out.println(notBannedCommonWord.mostCommonWord(paragraph, banned));
  }
}
