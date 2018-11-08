package com.peace.binary;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/08/18
 * Time:    2:13 AM
 */
public class SumTree {

  BinaryTree bt ;

  SumTree () {
    bt = new BinaryTree();
    bt.createSampleTree();
  }

  public int sumTreeUtil (Node t) {
   if ( t == null) return 0;
   int oldValue = t.value ;
   t.value = sumTreeUtil(t.left) + sumTreeUtil(t.right);
   return t.value + oldValue ;
  }

  public static void main(String[] args) {
    SumTree st = new SumTree();
    PrintLevelOrder.print(st.bt.root);
    st.sumTreeUtil(st.bt.root);
    PrintLevelOrder.print(st.bt.root);
  }

}
