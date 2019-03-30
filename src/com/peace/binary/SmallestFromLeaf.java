package com.peace.binary;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    18/03/19
 * Time:    2:21 AM

 Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".
 A leaf of a node is a node that has no children.)
 LeetCode : https://leetcode.com/problems/smallest-string-starting-from-leaf/

 */
public class SmallestFromLeaf {


  public static  String solution(Node t) {
    if(t != null) {
      String left = solution(t.left);
      String right = solution(t.right);
      if(left.length() > 0 && right.length() > 0) {
        return (left.compareTo(right) < 0 ? left : right) + (char) ('a' +t.value);
      }
      else if ( left.length() > 0) {
        return  left + (char) ('a' + t.value);
      } else {
        return  right + (char)( 'a' + t.value);
      }
    }
    return "";
  }



  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createSampleTree();
    System.out.println(solution(bt.root));
  }

}
