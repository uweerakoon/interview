package interview;

public class BSTNode {

  private int data;
  private BSTNode left;
  private BSTNode right;
  
  public BSTNode(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BSTNode getLeft() {
    return left;
  }

  public void setLeft(BSTNode left) {
    this.left = left;
  }

  public BSTNode getRight() {
    return right;
  }

  public void setRight(BSTNode right) {
    this.right = right;
  }
  
  public void insert(int data) {
    if(data < this.data && this.left != null) {
      this.left.insert(data);
    } else if(data < this.data) {
      this.left = new BSTNode(data);
    } else if(data > this.data && this.right != null) {
      this.right.insert(data);
    } else if(data > this.data) {
      this.right = new BSTNode(data);
    }
  }
  
  public BSTNode contain(int data) {
    if(this.data == data) {
      return this;
    }
    if(data < this.data && this.left != null) {
      return this.left.contain(data);
    } else if(data > this.data && this.right != null) {
      return this.right.contain(data);
    }
    return null;
  }
  
  public boolean validate(BSTNode node, Integer min, Integer max) {
    if( (min != null && min > node.getData())
        || (max != null && max < node.getData())) {
      return false;
    }
    if(node.left != null && !validate(node.left, min, node.data)) {
      return false;
    }
    if(node.right != null && !validate(node.right, node.data, max)) {
      return false;
    }
    return true;
  }
  
}
