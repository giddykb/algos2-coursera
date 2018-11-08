package com.peace.binary;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/08/18
 * Time:    8:52 PM
 */
public class DistanceBetweenTwoNodes {

  BinaryTree bt;
  DistanceBetweenTwoNodes (){
    bt = new BinaryTree();
    bt.createSampleTree();
  }

  public int solution(Node n1, Node n2) {

    Node lca = LCA(bt.root,n1,n2);
    int h1=  height(lca,n1, 0);
    System.out.println("N1 height :" + h1);
    int h2 = height(lca, n2,0);
    System.out.println("N2 height :" + h2);
    return  h1 + h2 ;


  }

  private int height(Node curr,Node n1,int lvl) {
    if (curr == null) return  0;
    if (curr.value == n1.value) {
      return lvl;
    }
    int leftLvl = height(curr.left,n1, lvl+1);
    int rightLvl = height(curr.right,n1, lvl+1);
    return  leftLvl != 0 ? leftLvl : rightLvl ;

   }

  private Node LCA(Node curr, Node n1,Node n2) {
    if ( curr == null) return  null;
    if (n1.value == curr.value || n2.value == curr.value) {
        return curr;
    }

    Node leftLCA = LCA(curr.left,n1,n2);
    Node rightLCA = LCA(curr.right, n1, n2);

    if (leftLCA != null && rightLCA != null) {
      return curr;
    }
    return  leftLCA !=null? leftLCA : rightLCA;
  }



  public static void main(String[] args) {
    DistanceBetweenTwoNodes d = new DistanceBetweenTwoNodes();
    int t = d.solution(new Node(15), new Node(65));
    System.out.println(t);
  }
}
