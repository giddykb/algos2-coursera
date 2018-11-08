package com.peace.bst;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    18/07/18
 * Time:    9:32 PM
 */

import elementory.sorting.QuickSelect;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class BST<Key extends  Comparable<Key>, Value> {


  private Node root;

  public  void  put(Key key, Value val) {
    root  = put(root, key, val);
  }

  private Node put(Node x, Key key, Value val){
    if( x == null) return new Node(key, val);
    int cmp = key.compareTo( x.getKey());
    if( cmp > 0){
      x.right = put(x.right,key, val);
    } else  if ( cmp < 0){
      x.left = put(x.left, key, val);
    } else  {
      x.value = val;
    }
    x.count = 1 + size(x.getLeft()) + size(x.getRight());
    return  x;
  }

  public Value get(Key key) {
    Node x = root;
    while (x != null) {
      int cmp = key.compareTo( x.getKey());
      if( cmp > 0) x = x.getRight();
      else if( cmp < 0) x = x.getLeft();
      else return  x.getValue();


    }
    return  null;
  }

  public  Key floor(Key key) {
    Node x = floor(root, key);
    if ( x == null) return  null;
    return  x.getKey();
  }

  private Node floor(Node x , Key key) {
    if( x == null) return  null;
    int cmp = key.compareTo( x.getKey());
    if ( cmp == 0) return  x;
    if ( cmp < 0) return floor(x.left,key);

    Node t  = floor(x.getRight(), key);
    if ( t != null) return  t;
    else return x;

  }


  public  Key ceiling(Key key){
    Node x = ceiling(root, key);
    if ( x == null) return  null;
    return  x.getKey();

  }

  public  Node ceiling(Node x, Key key){

    if (x == null) return  null;
    int cmp = key.compareTo(x.getKey());

    if( cmp == 0) return  x;
    if( cmp < 0 ) {
      Node t = ceiling(x.left,key);
      if ( t != null) return  t;
      else return  x;
    }
    return ceiling(x.getRight(), key);
  }


  public  void delete(Key key){

  }

  public Iterator<Key>  iterator(){

    return  null;
  }


  public Key min(){
    if( root == null) return  null;
    Node x = root ;
    while (x.getLeft() != null) {
      x = x.getLeft();
    }
    return  x.getKey() ;
  }

  public  Key max(){
    if( root == null) return  null;
    Node x = root ;
    while (x.getRight() != null) {
      x = x.getRight();
    }
    return  x.getKey() ;

  }


  public int size(){
    return size(root);
  }

  private  int size(Node x) {
    if( x== null ) return 0;
    return  x.count;
  }


  public  int rank(Key key){
    return  rank(root,key);
  }


  private int rank(Node x , Key key) {

    if ( x== null ) return  0;
    int cmp = key.compareTo(x.getKey());

    if( cmp <  0) return rank( x.getLeft(), key);
    else if( cmp > 0) return 1 + size(x.getLeft()) + rank( x.getRight(), key);
    else return  size(x.getLeft());

   }




 /*@Getter
 @Setter
 @Builder
 @ToString*/
 private  class  Node {
   private Key key;
   private Value value;
   private  Node left;
   private  Node right;
   private  int count ;

   public Node(Key key, Value val) {
     this.key = key;
     this.value = val;
     this.count = 1;
   }

   public Key getKey() {
     return key;
   }

   public void setKey(Key key) {
     this.key = key;
   }

   public Value getValue() {
     return value;
   }

   public void setValue(Value value) {
     this.value = value;
   }

   public Node getLeft() {
     return left;
   }

   public void setLeft(Node left) {
     this.left = left;
   }

   public Node getRight() {
     return right;
   }

   public void setRight(Node right) {
     this.right = right;
   }



   @Override
   public String toString() {
     return super.toString();
   }
 }






 public  static  void main(String [] args) {
   File file = new File("data/tinyST.txt");
   try {
     Scanner scr = new Scanner(file);
     int count = 0;
     BST<String, Integer> bst = new BST<>();
     while (scr.hasNextLine()) {
        bst.put(scr.next(),count++);
     }

     System.out.println(bst.min());
     System.out.println(bst.max());
     System.out.println(bst.floor("N"));
     System.out.println(bst.ceiling("N"));

   } catch (FileNotFoundException e) {
     e.printStackTrace();
   }
 }


}
