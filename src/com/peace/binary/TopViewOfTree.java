package com.peace.binary;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/08/18
 * Time:    7:09 PM
 */
public class TopViewOfTree {

  BinaryTree bt ;

  TopViewOfTree() {
    bt = new BinaryTree();
    bt.createSampleTree();

  }

  public  void topViewUtil(){
    topViewUtil(bt.root, 0);
  }

  private  void topViewUtil(Node curr, int currLevel){
    if (curr == null) return;
    Set<Integer> hSet  = new HashSet<>();

    Queue<NodeHd> queue  = new LinkedList<>();
    queue.add(new NodeHd(curr,0));

    while (!queue.isEmpty()) {
        NodeHd nodeHd = queue.poll();
        Node t = nodeHd.node;
        int lvl = nodeHd.level;
        if(!hSet.contains(lvl)) {
          System.out.println(t.value);
          hSet.add(lvl);
        }
       if (t.left != null) {
          queue.add(new NodeHd(t.left, lvl - 1));
        }
        if (t.right != null) {
        queue.add(new NodeHd(t.right, lvl + 1));
        }

    }

  }

  public static void main(String[] args) {
    TopViewOfTree tv = new TopViewOfTree();
    tv.topViewUtil();
  }

  // this class store horizontal distance of the node
  static class NodeHd{
    Node node;
    int level;

    NodeHd(Node n, int lvl){
      this.node = n;
      this.level = lvl;
    }

  }
}
