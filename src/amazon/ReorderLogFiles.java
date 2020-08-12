package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderLogFiles {

  public String[] reorderLogFiles(String[] logs) {
    if (logs == null || logs.length == 0) return logs;
    int len = logs.length;
    List<String> letterList = new ArrayList<>();
    List<String> digitList = new ArrayList<>();
    for (String log : logs) {
      if (log.split(" ")[1].charAt(0) < 'a') {
        digitList.add(log);
      } else {
        letterList.add(log);
      }
    }
    Collections.sort(letterList, (o1, o2) -> {
      String[] s1 = o1.split(" ");
      String[] s2 = o2.split(" ");
      int len1 = s1.length;
      int len2 = s2.length;
      for (int i = 1; i < Math.min(len1, len2); i++) {
        if (!s1[i].equals(s2[i])) {
          return s1[i].compareTo(s2[i]);
        }
      }
      return 0;
    });

    for (int i = 0; i < len; i++) {
      if (i < letterList.size())
        logs[i] = letterList.get(i);
      else logs[i] = digitList.get(i - letterList.size());
    }
    return logs;
  }
  
  public static void main(String[] args) {
    String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
    ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
    System.out.println(Arrays.toString(reorderLogFiles.reorderLogFiles(logs)));
  }
}
