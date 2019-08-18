package amazon;

import java.util.ArrayList;
import java.util.List;

public class SubTreeMinAvg {

  double max = Integer.MIN_VALUE;
  TreeNode maxNode = null;

  public TreeNode maximumAverageSubtree(TreeNode root) {
    if (root == null) return null;
    helper(root);
    return maxNode;
  }

  private double[] helper(TreeNode root) {
    if (root == null) return new double[] {0, 0};

    double curTotal = root.val;
    double count = 1;
    for (TreeNode child : root.children) {
      double[] cur = helper(child);
      curTotal += cur[0];
      count += cur[1];
    }        
    double avg = curTotal / count;
    if (avg > max) {
      max = avg;
      maxNode = root;
    }
    return new double[] {curTotal, count};
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode();
    root.val = 1;
//    root.children = new ArrayList<TreeNode>();
    
    TreeNode r_ch1 = new TreeNode(), r_ch2 = new TreeNode(), r_ch3 = new TreeNode();
    r_ch1.val = -5; r_ch2.val = 13; r_ch3.val = 4;
    root.children.add(r_ch1); root.children.add(r_ch2); root.children.add(r_ch3);
    
//    r_ch1.children = new ArrayList<TreeNode>();
    TreeNode r_ch1_ch1 = new TreeNode(), r_ch1_ch2 = new TreeNode();
    r_ch1_ch1.val = 1; r_ch1_ch2.val = 2;
    r_ch1.children.add(r_ch1_ch1); r_ch1.children.add(r_ch1_ch2); 
    
//    r_ch2.children = new ArrayList<TreeNode>();
    TreeNode r_ch2_ch1 = new TreeNode(), r_ch2_ch2 = new TreeNode();
    r_ch2_ch1.val = 4; r_ch2_ch2.val = -2;
    r_ch2.children.add(r_ch2_ch1); r_ch1.children.add(r_ch2_ch2); 
    
    SubTreeMinAvg subTreeMinAvg = new SubTreeMinAvg();
    System.out.println(subTreeMinAvg.maximumAverageSubtree(root).val);
  }
  
}

class TreeNode {
  int val;
  List<TreeNode> children = new ArrayList<TreeNode>();
}
