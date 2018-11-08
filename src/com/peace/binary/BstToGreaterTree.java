package com.peace.binary;

import java.util.Date;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/08/18
 * Time:    1:38 AM
 *
   Given a Binary Search Tree (BST), convert it to a Greater Tree such
   that every key of the original BST is changed to the original key plus sum
   of all keys greater than the original key in BST.

   Input: The root of a Binary Search Tree like this:
   5
   /   \
   2     13

   Output: The root of a Greater Tree like this:
   18
   /   \
   20     13

 */
public class BstToGreaterTree {
  BinaryTree bt;

  private  static int sum ;

  BstToGreaterTree () {
    bt = new BinaryTree() ;
    bt.createSampleTree();
  }

  public  void bstToGreaterTreeUtil(Node t) {
    if ( t == null ) return;
    bstToGreaterTreeUtil(t.right);
    sum = sum + t.value;
    t.value = sum;
    bstToGreaterTreeUtil(t.left);
  }

  public static void main(String[] args) {
/*

    BstToGreaterTree b = new BstToGreaterTree();
    PrintLevelOrder.print(b.bt.root);
    b.bstToGreaterTreeUtil(b.bt.root);
    PrintLevelOrder.print(b.bt.root);
*/

    Date d = new Date();
    System.out.println(String.valueOf(d));

  }
}

