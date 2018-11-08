package com.peace.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    14/08/18
 * Time:    10:47 PM
 */
public class VerticalOrder {

  BinaryTree bt ;

  VerticalOrder() {
    bt = new BinaryTree();
    bt.createSampleTree();
  }

  public void verticalOrderUtil() {
    TreeMap<Integer,List<Integer>> treeMap = new TreeMap<>();
    verticalOrderUtil(bt.root, 0, treeMap);
    treeMap.forEach( (k,v) ->
                         System.out.println(k + ": " + v));

  }

  public  void verticalOrderUtil(Node curr, int currLevel,TreeMap<Integer,List<Integer>> treeMap) {
    if( curr == null)  return;

    List<Integer> nodeList = treeMap.get(currLevel);
    if (nodeList != null) {
      nodeList.add(curr.value);
    } else {
      nodeList = new ArrayList<>();
      nodeList.add(curr.value);
    }

    treeMap.put(currLevel, nodeList);
    verticalOrderUtil(curr.left, currLevel - 1, treeMap);
    verticalOrderUtil(curr.right, currLevel + 1, treeMap );

  }

  public  void solution() {

    Node curr = bt.root;
    if ( curr == null) return;
    TreeMap<Integer,List<Integer>> treeMap = new TreeMap<>();
    Queue<NodeDistance> queue = new LinkedList<>();
    queue.add(new NodeDistance(bt.root, 0));

    while (!queue.isEmpty()) {
      NodeDistance nodeDistance = queue.remove();
      Node t = nodeDistance.node;
      int dist = nodeDistance.dist;

      List<Integer> list = treeMap.get(dist);
      list  =  (list == null )? list = new ArrayList<>(): list;
      list.add(t.value);
      treeMap.put(dist , list);

      if (t.left != null) queue.add( new NodeDistance( t.left, dist - 1));
      if (t.right != null) queue.add( new NodeDistance(t.right, dist +1 ));
    }

    treeMap.forEach( (k,v) ->
                         System.out.println(k + ": " + v));
  }

  // horizontal distance
  static class NodeDistance {
    Node node ;
    int dist;
    NodeDistance (Node n, int d){
      this.node = n;
      this.dist = d ;
    }
  }



  public static void main(String[] args) {
    VerticalOrder vo = new VerticalOrder();
    vo.verticalOrderUtil();
    System.out.println("\n###########\n");
    vo.solution();
  }
}
