package interview;

public class BST {

  private BSTNode root;
  
  public BSTNode insert(int value) {
    if(root == null) {
      BSTNode child = new BSTNode(value);
      root = child;
      return child;
    }
    return insert(root, value);
  }
  
  public BSTNode insert(BSTNode node, int value) {
    if(node.getData() > value) {
      if(node.getLeft() != null) {
        return insert(node.getLeft(), value);
      } else {
        BSTNode child = new BSTNode(value);
        node.setLeft(child);
        return child;
      }
    } else {
      if(node.getRight() != null) {
        return insert(node.getRight(), value);
      } else {
        BSTNode child = new BSTNode(value);
        node.setRight(child);
        return child;
      }
    }
  }
}
