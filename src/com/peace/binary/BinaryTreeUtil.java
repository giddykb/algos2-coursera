package com.peace.binary;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/04/19
 * Time:    9:02 PM
 */
public class BinaryTreeUtil {
  BinaryTree bt ;
  public static void main(String[] args) {

    BinaryTree bt  = new BinaryTree();
    bt.createSampleTree();
    invertTree(bt.root);

  }

  public static  Node invertTree(Node root) {
    if ( root == null) return null;
    Node right = invertTree(root.right);
    Node left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
  }
}
