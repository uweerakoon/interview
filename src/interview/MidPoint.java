package interview;

public class MidPoint<T> {

  public Node<T> getMidPoint(LinkedList<T> linkedList) {
    if(linkedList == null)
      return null;
    Node<T> slow = linkedList.getFirst();
    if(slow == null)
      return null;
    Node<T> fast = linkedList.getFirst();
    while(fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    return slow;      
  }
  
  public static void main(String[] args) {
    LinkedList<Integer> intLinkList = new LinkedList<>();
    intLinkList.insertFirst(4);
    intLinkList.insertFirst(3);
    intLinkList.insertFirst(2);
    intLinkList.insertFirst(1);
    MidPoint<Integer> midPoint = new MidPoint<>();
    intLinkList.print();
    System.out.println(midPoint.getMidPoint(intLinkList));
  }
}
