package adobe;

import java.util.Stack;

public class PreOrder {

  /*Input:  pre[] = {2, 4, 3}
  Output: true
  Given array can represent preorder traversal
  of below tree
      2
       
        4
       /
      3

  Input:  pre[] = {2, 4, 1}
  Output: false
  Given array cannot represent preorder traversal
  of a Binary Search Tree.

  Input:  pre[] = {40, 30, 35, 80, 100}
  Output: true
  Given array can represent preorder traversal
  of below tree
       40
     /   
   30    80 
          
    35     100 


  Input:  pre[] = {40, 30, 35, 20, 80, 100}
  Output: false
  Given array cannot represent preorder traversal
  of a Binary Search Tree.*/
  
  public boolean isPreOrderTraverse(int[] array) {
    Stack<Integer> memory = new Stack<>();
    int root = Integer.MIN_VALUE;
    for(int i=0; i<array.length; i++) {
      // If we find a node who is on right side 
      // and smaller than root, return false 
      if(array[i] < root) {
        return false;
      }
      // If pre[i] is in right subtree of stack top, 
      // Keep removing items smaller than pre[i] 
      // and make the last removed item as new 
      // root.
      while(!memory.empty() && memory.peek() < array[i]) {
        root = memory.pop();
      }
      // At this point either stack is empty or 
      // pre[i] is smaller than root, push pre[i] 
      memory.push(array[i]);
    }
    return true;
  }
  
  public static void main(String[] args) {
    PreOrder preOrder = new PreOrder();
    int[] pre = new int[]{2, 4, 3}; 
    System.out.println("Pre-Order Traversal: "+preOrder.isPreOrderTraverse(pre));
    pre = new int[]{2, 4, 1};
    System.out.println("Pre-Order Traversal: "+preOrder.isPreOrderTraverse(pre));
    pre = new int[]{40, 30, 35, 80, 100};
    System.out.println("Pre-Order Traversal: "+preOrder.isPreOrderTraverse(pre));
    pre = new int[]{40, 30, 35, 20, 80, 100};
    System.out.println("Pre-Order Traversal: "+preOrder.isPreOrderTraverse(pre));
  }
}
