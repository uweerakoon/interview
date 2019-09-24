package interview;

public class QueueFromStack {

  private Stack s1;
  private Stack s2;
  private String front;
  public QueueFromStack() {
    s1 = new Stack();
    s2 = new Stack();
  }
  
  public Node push(String value) {
    if(s1.peek() == null && s2.peek() == null) {
      front = value;
    }
    return s1.push(value);
  }
  
  public Node pop() {
    if(s2.peek() == null) {
      populate();
    }
    Node temp = s2.pop();
    if(s2.peek() != null) {
      front = s2.peek().getData().toString();
    }
    return temp;
  }
  
  private void populate() {
    while(s1.peek() != null) {
      s2.push(s1.pop().getData().toString());
    }
    if(s2.peek() != null) {
      front = s2.peek().getData().toString();
    }
  }
  
  public String peek() {
    if(s2.peek() == null) {
      populate();
    }
    if(isEmpty()) {
      return null;
    }
    return front;
  }
  
  public boolean isEmpty() {
    return s1.peek() == null && s2.peek() == null;
  }
  
  public static void main(String[] args) {
    QueueFromStack qs = new QueueFromStack();
    qs.push("1");qs.push("2");qs.push("3");
    System.out.println("Peek: "+qs.peek());
    System.out.println("value removed: "+qs.pop().getData());
    qs.push("4");
    System.out.println("Peek: "+qs.peek());
    System.out.println("value removed: "+qs.pop().getData());
    qs.push("5");
    System.out.println("Peek: "+qs.peek());
    System.out.println("value removed: "+qs.pop().getData());
    System.out.println("Peek: "+qs.peek());
    System.out.println("value removed: "+qs.pop().getData());
    System.out.println("Peek: "+qs.peek());
    System.out.println("value removed: "+qs.pop().getData());
  }
}
