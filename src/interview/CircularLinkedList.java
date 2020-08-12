package interview;

public class CircularLinkedList<T> {

  public boolean isCircularLinkedList(LinkedList<T> linkedList) {
    if(linkedList == null)
      return false;
    Node<T> slow = linkedList.getFirst();
    if(slow == null)
      return false;
    Node<T> fast = linkedList.getFirst();
    while(fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if(slow == fast)
        return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    LinkedList<Integer> intLinkList = new LinkedList<>();
    intLinkList.insertFirst(4);
    intLinkList.insertFirst(3);
    intLinkList.insertFirst(2);
    intLinkList.insertFirst(1);
    intLinkList.print();
    Node<Integer> first = intLinkList.getFirst();
    Node<Integer> last = intLinkList.getLast();
    last.setNext(first);
    CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
    System.out.println(circularLinkedList.isCircularLinkedList(intLinkList));
  }
}
