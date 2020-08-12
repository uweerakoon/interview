package interview;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

  private T data;
  private List<TreeNode<T>> children;
  
  public TreeNode() {
    data = null;
    children = new ArrayList<>();
  }
  
  public TreeNode(T data) {
    this.data = data;
    children = new ArrayList<>();
  }
  
  public TreeNode<T> add(T data) {
    TreeNode<T> child = new TreeNode<>(data);
    children.add(child);
    return child;
  }
  
  public boolean remvoe(T data) {
    return children.removeIf(ch -> ch.getData().equals(data));
  }
  
  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public List<TreeNode<T>> getChildren() {
    return children;
  }

  public void setChildren(List<TreeNode<T>> children) {
    this.children = children;
  }
  
  public void print() {
    System.out.println("Data: "+data.toString());
    for(TreeNode<T> node : children) {
      System.out.print(" | "+node.getData().toString());
    }
  }
  
  @Override
  public String toString() {
    return data.toString();
  }
  
}
