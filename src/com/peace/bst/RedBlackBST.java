package com.peace.bst;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    30/07/18
 * Time:    9:04 AM
 */
public class RedBlackBST<Key extends  Comparable<Key>, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private  class Node {
    Key key;
    Value val;
    Node left;
    Node right;
    boolean color;

    Node(Key key, Value val,boolean color) {
      this.key = key;
      this.val = val;
      this.color  = color;
    }

    public void put (Key key, Value val) {
      root = put(root, key, val);
    }

    private Node put( Node x ,Key key, Value val ) {

      if ( x == null) return  new Node(key,val, RED);

      int cmp = key.compareTo(x.key);
      if( cmp < 0)  x.left = put(x.left, key, val);
      else if ( cmp > 0) x.right = put( x.right, key, val);
      else x.val = val;

      if( isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
      if (isRed( x.left) && isRed( x.left.left)) x = rotateRight(x);
      if( isRed( x.left) && isRed( x.right))  flipColors(x);

      return x;
    }

    private  Node rotateLeft(Node h){
      Node x = h.right;
      h.right = x.left;
      x.left = h ;
      x.color = h.color;
      h.color = RED;
      return  x;
    }

    private  Node rotateRight(Node h ){
      Node x = h.left;
      h.left = x.right;
      x.right = h;
      x.color = h.color;
      h.color = RED;
      return  x;
    }

    private  Node flipColors(Node h){
      h.color = RED;
      h.left.color = BLACK;
      h.right.color = BLACK;
      return  h;
    }


    private  boolean isRed( Node h) {
      return  h.color == RED;
    }
  }
}
