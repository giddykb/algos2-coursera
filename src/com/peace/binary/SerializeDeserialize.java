package com.peace.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/12/18
 * Time:    12:59 AM
 */
public class SerializeDeserialize {


  public static String serialize( Node root) {
    ArrayList<Integer> result = new ArrayList<>();
    serializeHelper(root, result);
    return result.toString();
  }

  public static void serializeHelper( Node node, ArrayList<Integer> result) {

    if( node == null)  {
      result.add(null);
      return;
    }
    result.add(node.value);
    serializeHelper(node.left, result);
    serializeHelper(node.right, result);
  }


  public  Node deSerialize( String data) {
    String [] strArray  = data.substring(1,data.length()-1).split(",");
    Deque<String> strList = new LinkedList<>(Arrays.asList(strArray));
    Node root  = deSerializeHelper(strList);
    return root;
  }

   Node deSerializeHelper(Deque<String> strList ) {
    if (strList.isEmpty()) return null;
    String str = strList.pop();
    if (str.trim().equals("null")) return null;
    Node currentNode = new Node(Integer.parseInt(str.trim()));
    currentNode.left = deSerializeHelper(strList);
    currentNode.right = deSerializeHelper(strList);
    return currentNode;
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createSampleTree();
    bt.preOrder();
    String result  = serialize(bt.root);
    System.out.println("\nSerialize " + result);
    SerializeDeserialize sd = new SerializeDeserialize();
    bt.root = sd.deSerialize(result);
    System.out.println("\nDeserialize" );
    bt.preOrder();

  }
}
