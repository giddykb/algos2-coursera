package com.peace.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    20/08/18
 * Time:    10:07 PM
 */
public class PrintLevelOrder {


  public static void print(Node t) {
    if (t == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(t);
    while (!queue.isEmpty()) {
      int lvlNodes = queue.size();
      while (lvlNodes > 0){
        Node n = queue.remove();
        System.out.print(n.value + " ");
        if(n.left  != null) queue.add(n.left);
        if(n.right != null) queue.add(n.right);
        lvlNodes-- ;
      }
      System.out.println();
    }
  }

}
