package interview;

public class Weave {
  
  public Queue weave(Queue q1, Queue q2) {
    Queue total = new Queue();
    while(q1.peek() != null || q2.peek() != null) {
      if(q1.peek() != null) {
        total.push(q1.pop().getData().toString());
      }
      
      if(q2.peek() != null) {
        total.push(q2.pop().getData().toString());
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Queue source1 = new Queue();
    source1.push("1");source1.push("2");source1.push("3");
    Queue source2 = new Queue();
    source2.push("Hi");source2.push("You");source2.push("There");
    Weave w = new Weave();
    Queue total = w.weave(source1, source2);
    total.printValues();
  }
}
