package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Tree<T> {

  private TreeNode<T> root;
  
  public void traverseBF(TreeOperation<T> treeOperation) {
    List<TreeNode<T>> memory = new ArrayList<>();
    memory.add(root);
    while(!memory.isEmpty()) {
      TreeNode<T> treeNode = memory.remove(0);
      memory.addAll(treeNode.getChildren());
      treeNode.setData(treeOperation.operate(treeNode.getData()));
    }
  }
  
  public void traverseDF(TreeOperation<T> treeOperation) {
    List<TreeNode<T>> memory = new ArrayList<>();
    memory.add(root);
    while(!memory.isEmpty()) {
      TreeNode<T> treeNode = memory.remove(0);
      memory.addAll(0, treeNode.getChildren());
      treeNode.setData(treeOperation.operate(treeNode.getData()));
    }
  }

  public TreeNode<T> getRoot() {
    return root;
  }

  public void setRoot(TreeNode<T> root) {
    this.root = root;
  }
  
  public void printBF() {
    List<TreeNode<T>> memory = new ArrayList<>();
    memory.add(root);
    System.out.println("\nPrinting the Tree: Breadth First");
    while(!memory.isEmpty()) {
      TreeNode<T> treeNode = memory.remove(0);
      memory.addAll(treeNode.getChildren());
      System.out.print(" | "+treeNode.getData().toString());
    }
  }
  
  public void printDF() {
    List<TreeNode<T>> memory = new ArrayList<>();
    memory.add(root);
    System.out.println("\nPrinting the Tree: Depth First");
    while(!memory.isEmpty()) {
      TreeNode<T> treeNode = memory.remove(0);
      memory.addAll(0,treeNode.getChildren());
      System.out.print(" | "+treeNode.getData().toString());
    }
  }
  
  private final TreeNode<T> STOPPER = new TreeNode<>();
  
  public List<AtomicInteger> getWidth(TreeNode<T> rootNode) {
    List<AtomicInteger> counter = new ArrayList<>();
    List<TreeNode<T>> memory = new ArrayList<>();
    memory.add(rootNode);
    memory.add(STOPPER);
    counter.add(new AtomicInteger(0));
    while(memory.size() > 1) {
      TreeNode<T> treeNode = memory.remove(0);
      if(treeNode != STOPPER) {
        counter.get(counter.size()-1).incrementAndGet();
        memory.addAll(treeNode.getChildren());
      } else {
        memory.add(STOPPER);
        counter.add(new AtomicInteger(0));
      }
    }
    return counter;
  }
  
  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<>();
    TreeNode<Integer> tn1 = new TreeNode<>(20);
    tree.setRoot(tn1);
    
    TreeNode<Integer> tn2 = tn1.add(0); 
    tn1.add(40);
    TreeNode<Integer> tn4 = tn1.add(-15);
    
    tn2.add(12);
    tn2.add(-2);
    tn2.add(1);
    
    tn4.add(-2);
    /*tree.printBF();
    tree.traverseBF((a) -> {return a+10;});
    tree.printBF();*/
    
    /*tree.printDF();
    tree.traverseDF((a) -> {return a+10;});
    tree.printDF();*/
    
    System.out.println(tree.getWidth(tn1));
  }
  
}

interface TreeOperation<T> {
  public T operate(T t);
}
