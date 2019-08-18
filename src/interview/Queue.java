package interview;

public class Queue {
  private Node head;
  private Node tail;
  
  public Node push(String val) {
    Node node = new Node();
    node.value = val;
    node.next = null;
    if(tail != null) { // make the link to the next one
      tail.next = node;
    }
    tail = node;
    if(head == null) {
      head = node;
    }
    return node;
  }
  
  public Node pop() {
    if(head == null) {
      System.out.println("No elements to remove");
      return null;
    }
    Node node = head;
    if(head.next == null) {
      head = null;
      tail = null;
    } else {
      head = head.next;
    }
    node.next = null;
    return node;
  }
  
  public Node peek() {
    if(head == null) {
      System.out.println("There is not elements in the queue");
      return null;
    }
    return head;
  }
  
  public void printValues() {
    Node temp = head;
    System.out.print("\nThe queue is as follows:     ");
    while(temp != null) {
      System.out.print("   "+temp.value);
      temp = temp.next;
    }
  }
  
  public static void main(String[] args) {
    Queue q = new Queue();
    q.push("1");
    q.push("2");
    q.push("3");
    q.push("3");
    q.push("4");
    q.printValues();
    q.pop();
    q.printValues();
    q.pop();
    q.printValues();
    q.pop();q.pop();q.pop();
    q.printValues();
    q.pop();
  }

}

class Node {
  Node next;
  String value;
}
