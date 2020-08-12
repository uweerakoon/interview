package adobe;

public class MirrorTree {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(); 
    tree.root = new Node(1); 
    tree.root.left = new Node(2); 
    tree.root.right = new Node(3); 
    tree.root.left.left = new Node(4); 
    tree.root.left.right = new Node(5); 
    /* print inorder traversal of the input tree */
    System.out.println("Inorder traversal of input tree is :"); 
    tree.inOrder(); 
    System.out.println(""); 

    /* convert tree to its mirror */
    tree.mirror(); 

    /* print inorder traversal of the minor tree */
    System.out.println("Inorder traversal of binary tree is : "); 
    tree.inOrder(); 
  }
}

class Node {
  int data;
  Node right, left;
  public Node(int data) {
    this.data = data;
    right = left = null;
  }
}


class BinaryTree {
  Node root;
  public void mirror() {
    root = mirror(root);
  }
  private Node mirror(Node node) {
    if(node == null) 
      return node;
    // do the subtree
    Node left = mirror(node.left);
    Node right = mirror(node.right);
    // swap let and right
    node.left = right;
    node.right = left;
    
    return node;
  }
  
  public void inOrder() {
    inOrder(root);
  }
  
  private void inOrder(Node node) {
    if(node == null)
      return;
    inOrder(node.left);
    System.out.println(node.data+ " ");
    inOrder(node.right);
  }
}
