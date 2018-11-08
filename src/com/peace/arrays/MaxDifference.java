package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/07/18
 * Time:    7:08 PM
 *
 *
 * Maximum difference between two elements such that larger element appears after the smaller number
 */
public class MaxDifference {

  public  static  void main(String [] args) {

    //int a [] = {14, 12, 70, 15, 95, 65, 22, 30};
    int a [] = {7, 9, 5, 6, 3, 2};
    System.out.println(" Max profit " + findMaxDifference(a));
  }

  private static int findMaxDifference(int a[]) {

    int maxDiff = Integer.MIN_VALUE;
    int minElementsSoFar = a[0];
    for (int i = 1; i < a.length ; i++) {
      if( a[i] > minElementsSoFar){
         maxDiff = Math.max(maxDiff, a[i] - minElementsSoFar);
      } else {
        minElementsSoFar = a[i];
      }
    }

    return  maxDiff;
  }


}
