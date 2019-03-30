package com.peace.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    02/08/18
 * Time:    1:43 AM
 */
public class BinaryTree {

  Node root;

  public  void  inOrder(){
    inOrder(root);
  }

  public  void  preOrder(){
    preOrder(root);
  }
  public  void  postOrder(){
    postOrder(root);
  }

  public Integer LCA(Node n1, Node n2)  throws  Exception{
    List<Integer> path_1 = new ArrayList<>();
    List<Integer> path_2 = new ArrayList<>();
    path_1.clear();path_2.clear();

    if( !findPath(root,n1,path_1) || !findPath(root, n2, path_2)) {
      return  -1;
    }


    int minLength = Math.min(path_1.size() , path_2.size());
    Integer res = null;
    for (int i = 0; i < minLength; i++) {

      if( path_1.get(i) != path_2.get(i)) break;
      else res = path_1.get(i);
    }
    return  res;

  }

  public Node LCAOptimalSolution(Node n1, Node n2) {
    return LCAOptimalSolution(root, n1, n2);
  }

  private  Node LCAOptimalSolution(Node curr,Node n1, Node n2) {

    if (curr == null) return  null;
    if( curr.value == n1.value || curr.value == n2.value) {
      return  curr;
    }

    Node left_lca = LCAOptimalSolution(curr.left, n1, n2);
    Node right_lca = LCAOptimalSolution(curr.right, n1, n2);

    if (left_lca != null && right_lca != null) {
      return  curr;
    }

    return  left_lca != null? left_lca : right_lca;

  }

  public  List<Integer>  findPath( Node node) throws  Exception{
    List<Integer> path = new ArrayList<>();
    findPath(root, node,path);
    return path;

  }

  private  boolean findPath(Node curr,Node node,List<Integer> path) throws Exception {

    if (node == null) return false;
    path.add(curr.value);
    if (curr.value == node.value) return true;
    if (curr.left != null && findPath(curr.left, node, path)){
      return  true;
    }
    if( curr.right != null &&  findPath(curr.right, node, path)) {
      return true;
    }
    path.remove(path.size() -1);
    return false;

  }

  public void printPaths() {
    List<List<Integer>>  allPaths = new ArrayList<>();
    printPaths(root,new ArrayList<Integer>(), allPaths);
    allPaths.forEach(
        (path) -> System.out.println(path + "\n")
    );

  }

  private void printPaths(Node node, List<Integer> path, List<List<Integer>>  allPaths) {
    if( node == null) return;
    path.add(node.value);
    if(node.left == null && node.right == null) {
      allPaths.add(path);
      return;
    } else {
      printPaths(node.left, new ArrayList<>(path), allPaths);
      printPaths(node.right, new ArrayList<>(path), allPaths);

    }
 }


 public void printRightView(){
   Queue<Node> queue = new LinkedList<>();
   queue.add(root);

   while (!queue.isEmpty()) {
     int levelNodes = queue.size();
     while (levelNodes > 0) {
       Node n = queue.remove();
       levelNodes--;
       if (levelNodes == 0) {
         System.out.println(n.value);
       }
       if (n.left != null) queue.add(n.left);
       if (n.right != null) queue.add(n.right);
     }


   }


 }

  private void inOrder(Node n){
    if ( n == null) return;
    inOrder(n.left);
    System.out.print( n.value + " " );
    inOrder(n.right);
  }

  private void preOrder(Node n){
    if ( n == null) return;
    System.out.print( n.value + " " );
    inOrder(n.left);
    inOrder(n.right);
  }

  private void postOrder(Node n){
    if ( n == null) return;
    inOrder(n.left);
    inOrder(n.right);
    System.out.print( n.value + " " );
  }


  public void createSampleTree(){
   /* Node t1 = new Node(1);
    Node t2 = new Node(2);
    Node t3= new Node(3);
    Node t4 = new Node(4);
    Node t5 = new Node(5);
    Node t6 = new Node(6);
    Node t7 = new Node(7);
    Node t8 = new Node(8);
    Node t9 = new Node(9);
    root=t1;

    //t8.left=t9;
    //t4.right=t8;
    t2.left=t4;
    t2.right=t5;
    t3.left=t6;
    t3.right=t7;
    root.left=t2;
    root.right=t3;*/
    Node n1 = new Node(25);
    Node n2 = new Node(1);
    Node n3 = new Node(3);
    Node n4  = new Node(1);
    Node n5 = new Node(3);
    Node n6 = new Node(0);
    Node n7 = new Node(2);
    n1.right = n3;
    n1.left = n2;
    n2.left = n4; n2.right = n5;
    n3.left = n6 ; n3.right = n7;

    /*Node n4 = new Node(-2);
    Node n5 = new Node(4);
    Node n6 = new Node(-6);
    Node n7 = new Node(10);*/
//    Node n8 = new Node(45);
//    n8.right = new Node(65);
//    n1.left = n2 ;
//    n1.right = n3;
//    /*n2.left = n4;
//    n2.right = n5 ;
//    n3.left = n6;
//    n3.right = n7;*/
//   // n5.right = n8;
    this.root = n1;

  }

  /*private  static  class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }

  }*/

  public  int height(Node node){
  return height(root,node,-1);
  }

  public int height(Node curr,Node n,int h) {
    if (curr == null) {
      return  -1;
    }

    if( curr.value == n.value) return 1;
    height(curr.left,n,1+h);
    height(curr.right,n,1+h);
    return  h;
  }


  public static void  main(String [] args) {

    BinaryTree bt = new BinaryTree();
    bt.createSampleTree();
    bt.printPaths();
    try{
      //Integer lca = bt.LCA(new Node(4),new Node (2));
      //Node res = bt.LCAOptimalSolution(new Node(4),new Node (3));
      //System.out.println("LCA is "  +res.value);
      //bt.printRightView();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
