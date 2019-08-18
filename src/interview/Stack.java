package interview;

public class Stack {
  private Node pointer;
  public Node push(String value) {
    Node node = new Node();
    node.value = value;
    if(pointer != null) {
      node.next = pointer;
    } 
    pointer = node;
    return node;
  }
  
  public Node pop() {
    if(pointer == null) {
      System.out.println("No data to be poped");
      return null;
    }
    Node temp = pointer;
    pointer = pointer.next;
    temp.next = null;
    return temp;
  }
  
  public Node peek() {
    if(pointer == null) {
      System.out.println("Stack is empty");
      return null;
    }
    return pointer;
  }
  
  public void printValues() {
    Node temp = pointer;
    System.out.print("\nThe Stack is as follows:     ");
    while(temp != null) {
      System.out.print("   "+temp.value);
      temp = temp.next;
    }
  }
  
  public static void main(String[] args) {
    Stack s = new Stack();
    s.push("1");s.push("2");s.push("3");
    s.printValues();
    s.pop();
    s.printValues();
    s.pop();
    s.printValues();
    s.pop();
    s.printValues();
  }

}
