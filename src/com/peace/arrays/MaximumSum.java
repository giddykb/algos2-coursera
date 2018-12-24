package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/12/18
 * Time:    1:43 PM
 *
 *
 *
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

 For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

 */
public class MaximumSum {

  public static void main(String[] args)  throws  Exception{

    int a [] = {2, 4, 6, 2, 5};
    System.out.println(maxSum(a));

  }


  static int maxSum(int a[]) throws Exception {
    if (a.length == 0) throw new Exception("Array cannot be empty");

    int incl = a[0];
    int excl = 0;

    for (int i = 1; i < a.length; i++) {
      int exclNew = Math.max(incl, excl);
      incl = a[i] + excl;
      excl = exclNew;
    }

    return Math.max(incl, excl);
  }
}
