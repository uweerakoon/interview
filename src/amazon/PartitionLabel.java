package amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {

  public List<Integer> partitionLabels(String S) {
    int[] last = new int[26];
    for (int i = 0; i < S.length(); ++i)
      last[S.charAt(i) - 'a'] = i;

    int j = 0, anchor = 0;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < S.length(); ++i) {
      j = Math.max(j, last[S.charAt(i) - 'a']);
      if (i == j) {
        ans.add(i - anchor + 1);
        anchor = i + 1;
      }
    }
    return ans;
  }
  
  public static void main(String[] args) {
    PartitionLabel partitionLabel = new PartitionLabel();
    System.out.println(partitionLabel.partitionLabels("ababcbacadefegdehijhklij"));
  }
}
