package interview;

import java.util.ArrayList;
import java.util.Objects;

public class LinkedList<T> {
  private Node<T> head;
  
  public LinkedList() {
    this.head = null;
  }
  
  public Node<T> insertFirst(T value) {
//    this.head = new Node(value, this.head);
//    return this.head;
    return this.insertAt(value, 0);
  }
  
  public int size() {
    int count = 0;
    Node<T> temp = this.head;
    while(temp != null) {
      count++;
      temp = temp.getNext();
    }
    return count;
  }
  
  public Node<T> getFirst() {
//    return this.head;
    return this.getAt(0);
  }
  
  public Node<T> getLast() {
    /*if(this.head == null)
      return null;
    Node node = this.head;
    while(node.getNext() != null) {
      node = node.getNext();
    }
    return node;*/
    return this.getAt(this.size() - 1);
  }
  
  public void clear() {
    this.head = null;
  }
  
  public Node<T> removeFirst() {
    /*if(this.head == null)
      return null;
    Node node = this.head;
    this.head = node.getNext();
    node.setNext(null);
    return node;*/
    return this.removeAt(0);
  }
  
  public Node<T> removeLast() {
    /*if(this.head == null)
      return null;
    Node previous = this.head;
    if(previous.getNext() == null) {
      this.head = null;
      return previous;
    }
    Node node = previous.getNext();
    while(node.getNext() != null) {
      previous = node;
      node = node.getNext();
    }
    previous.setNext(null);
    return node;*/
    return this.removeAt(this.size() - 1);
  }
  
  public Node<T> insertLast(T value) {
    /*Node node = new Node(value);
    Node lastNode = this.getLast();
    if(lastNode != null)
      lastNode.setNext(node);
    else 
      this.head = node;
    return node;*/
    return this.insertAt(value, this.size() - 1);
  }
  
  public Node<T> getAt(int index) {
    Node<T> node = this.head;
    int count = 0;
    while(node != null) {
      if(count == index) {
        return node;
      }
      node = node.getNext();
      count++;
    }
    return node;
  }
  
  public Node<T> removeAt(int index) {
    if(this.head == null)
      return null;
    Node<T> node = null;
    if(index == 0) {
      node = this.head;
      head = node.getNext();
      node.setNext(null);
      return node;
    }
    Node<T> previousNode = this.getAt(index-1);
    if(previousNode != null && previousNode.getNext() != null) {
      node = previousNode.getNext();
      previousNode.setNext(node.getNext());
      node.setNext(null);
    }
    return node;
  }
  
  public Node<T> insertAt(T value, int index) {
    if(this.head == null) {
      this.head = new Node<T>(value);
      return head;
    }
    if(index == 0) {
      this.head = new Node<T>(value, this.head);
      return this.head;
    }
    Node<T> previousNode = this.getAt(index-1);
    if(previousNode == null) {
      previousNode = this.getLast();
    }
    Node<T> node = new Node<T>(value, previousNode.getNext());
    previousNode.setNext(node);
    return node;
  }
  
  public void foreach(CustomizeInterface<T> action) {
    Objects.requireNonNull(action);
    Node<T> node = this.head;
    while(node != null) {
      node.setData(action.operation(node.getData()));
      node = node.getNext();
    }
  }
  
  public void print() {
    Node<T> node = this.head;
    while(node != null) {
      System.out.print(node.getData().toString()+ (node.getNext() != null ? " -> " : ""));
      node = node.getNext();
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    LinkedList<Integer> intLinkList = new LinkedList<>();
    intLinkList.insertFirst(4);
    intLinkList.insertFirst(3);
    intLinkList.insertFirst(2);
    intLinkList.insertFirst(1);
    intLinkList.print();
//    CustomizeInterface<Integer> custInterface = (a) -> {return a+10;};
//    intLinkList.foreach(custInterface);
    intLinkList.foreach((a) -> {return a+10;});
    intLinkList.print();
  }
}

interface CustomizeInterface<T> {
  T operation(T value);
}
