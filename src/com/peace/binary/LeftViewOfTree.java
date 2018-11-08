package com.peace.binary;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/08/18
 * Time:    6:58 PM
 */
public class LeftViewOfTree {

  private  static  int maxLevelSoFar = 0;
  BinaryTree bt ;
  LeftViewOfTree() {
    bt = new BinaryTree();
    bt.createSampleTree();

  }

  public  void  LeftView(){
    LeftViewUtil(bt.root, 1);
  }

  private  void LeftViewUtil(Node curr, int currLvl){
    if ( curr == null) return;

    if( currLvl > maxLevelSoFar ) {
      System.out.println(curr.value);
      maxLevelSoFar = currLvl;
    }
    LeftViewUtil(curr.left, currLvl +1 );
    LeftViewUtil(curr.right, currLvl +1 );

  }

  public static void main(String[] args) {
    LeftViewOfTree lt = new LeftViewOfTree();
    lt.LeftView();
  }
}
