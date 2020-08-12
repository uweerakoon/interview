package interview;

public class BackTail<T> {

  public Node<T> getBackTail(LinkedList<T> linkedList, int n) {
    Node<T> slow = linkedList.getFirst();
    Node<T> fast = linkedList.getFirst();
    for(int i=0; i<n; i++) {
      fast = fast.getNext();
    }
    while(fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext();
    }
    return slow;
  }
  
  public static void main(String[] args) {
    LinkedList<Integer> intLinkList = new LinkedList<>();
    intLinkList.insertFirst(4);
    intLinkList.insertFirst(3);
    intLinkList.insertFirst(2);
    intLinkList.insertFirst(1);
    intLinkList.print();
    BackTail<Integer> backTail = new BackTail<>();
    System.out.println(backTail.getBackTail(intLinkList, 2));
  }
}
