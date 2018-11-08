package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/09/18
 * Time:    4:55 PM
 *
 * Given a number n, find the smallest number that has same set of digits as n and is greater than n.
 * If x is the greatest possible number with its set of digits, then print “not possible”.

 Input:  n = "218765"
 Output: "251678"

 */
public class NextGreater {


  public static void main(String[] args) {

  }


  private int[] solution(int[] a ) {

    int idx = -1;

    for (int i = a.length - 1; i > 0; i--) {
      if (a[i-1] < a[i]) {
        idx = i-1;
        break;
      }
    }

    if( idx != -1) {

      int small = a[idx+1];
      int min = idx+1;
      for (int i = idx+1; i < a.length-1 ; i++) {

        if( a[i] < small) {

        }
      }
    }

    return a;
  }

}
