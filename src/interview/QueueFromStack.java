package interview;

public class QueueFromStack {

  private Stack s1;
  private Stack s2;
  public QueueFromStack() {
    s1 = new Stack();
    s2 = new Stack();
  }
  
  public Node push(String value) {
    return s1.push(value);
  }
  
  public Node pop() {
    if(s2.peek() == null) {
      while(s1.peek() != null) {
        s2.push(s1.pop().value);
      }
    }
    return s2.pop();
  }
  
  public boolean isEmpty() {
    return s1.peek() == null && s2.peek() == null;
  }
  
  public static void main(String[] args) {
    QueueFromStack qs = new QueueFromStack();
    qs.push("1");qs.push("2");qs.push("3");
    System.out.println("value removed: "+qs.pop().value);
    qs.push("4");
    System.out.println("value removed: "+qs.pop().value);
    qs.push("5");
    System.out.println("value removed: "+qs.pop().value);
    System.out.println("value removed: "+qs.pop().value);
    System.out.println("value removed: "+qs.pop().value);
  }
}
