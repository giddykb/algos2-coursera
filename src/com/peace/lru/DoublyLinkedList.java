package com.peace.lru;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    20/09/18
 * Time:    6:12 AM
 */

@Getter
@Setter
public class DoublyLinkedList {


  private Node head;
  private Node tail;
  private int capacity;
  private int size;

  DoublyLinkedList( int capacity) {
    this.capacity = capacity;
    this.size = 0;
  }

  public Node addPage(int pageNo) {
    Node n = new Node(pageNo);
    if (head == null) {
      head = n;
      tail = n;
      size = 1 ;
    }
    else if ( size < capacity) {
      size++;
    }
    else {
      tail = tail.getPrev();
      tail.setNext(null);
    }

    n.setNext(head);
    head.setPrev(n);
    head  = n;
    return n;

  }

  public void movePageToHead(Node n) {

    if ( n == null || n == head){
      return;
    }

    if ( n == tail) {
      tail = tail.getPrev();
      tail.setNext(null);
    }

    Node prev = n.getPrev();
    Node next = n.getNext();
    prev.setNext(next);

    if (next != null) {
      next.setPrev(prev);
    }

    n.setPrev(head);
    n.setPrev(null);
    head.setPrev(n);
    head = n;

  }

  public void remove(){
    if ( size == capacity) {
      if ( head == null) return;
      else if ( head == tail) {
        head = null;
        tail = null;
      } else {
        tail = tail.getPrev();
        tail.setNext(null);
      }
      size --;
    }
  }

  public  void print() {
    if ( head == null) return;
    Node t  = head;
    while( t != null) {
      System.out.print(t.getPageNo() + "");
      t = t.getNext();
    }

  }

public Node getHead() {
	return head;
}

public void setHead(Node head) {
	this.head = head;
}

public Node getTail() {
	return tail;
}

public void setTail(Node tail) {
	this.tail = tail;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}



}
