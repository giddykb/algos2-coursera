package com.peace.binary;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/08/18
 * Time:    6:03 PM
 */
public class RightViewOfTree {

  static  BinaryTree bt ;
  private  int maxLevel;

  RightViewOfTree () {
    bt = new BinaryTree();
    Node n1 = new Node(5);
    Node n2 = new Node(10);
    Node n3 = new Node(15);
    Node n4 = new Node(20);
    Node n5 = new Node(25);
    Node n6 = new Node(30);
    Node n7 = new Node(35);
    Node n8 = new Node(45);
    n1.left = n2 ;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5 ;
    n3.left = n6;
    n3.right = n7;
    n5.right = n8;
    bt.root = n1;
    //bt.createSampleTree(45);
  }

  public void printRightView() {
    rightViewUtil(bt.root, 1);
  }
  private void rightViewUtil(Node curr,  int nextLevel) {

    if ( curr == null) return;

    if (maxLevel < nextLevel) {
      System.out.println(curr.value);
      maxLevel  = nextLevel;
    }

    rightViewUtil(curr.right, nextLevel + 1);
    rightViewUtil(curr.left, nextLevel + 1 );

  }

  public static  void main(String [] args) {
    RightViewOfTree rt = new RightViewOfTree();
    rt.printRightView();
  }
}
