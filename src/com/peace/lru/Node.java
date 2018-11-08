package com.peace.lru;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private int pageNo;
    private Node next;
    private  Node prev;

    Node(int pageNo) {
      this.pageNo = pageNo;
    }

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

  }