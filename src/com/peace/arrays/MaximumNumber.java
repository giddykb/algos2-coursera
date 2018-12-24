package com.peace.arrays;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/12/18
 * Time:    5:00 PM
 *
 *
 * Given a positive integer, find maximum integer possible by doing
 * at-most K swap operations on its digits.

 Input: M = 254, K = 1
 Output: 524

 Input: M = 254, K = 2
 Output: 542

 Input: M = 68543, K = 1
 Output: 86543

 Input: M = 7599, K = 2
 Output: 9975

 Input: M = 76543, K = 1
 Output: 76543

 Input: M = 129814999, K = 4
 Output: 999984211

 */
public class MaximumNumber {

  public static void main(String[] args) {

    int inp = 129814999;
    int  k  = 4 ;
    System.out.println(maxNumber(inp, k));
    int a [] = {7,5,9,9};
    System.out.println(Arrays.toString(maximize(a, 5)));


    /*
    char ch [] = String.valueOf(inp).toCharArray();
    int res = findMaximum(ch, k, inp);
    System.out.println("Result:: " + res);
    */

  }


  static int findMaximum(char ch [], int k, int maxSoFar) {

    if ( k ==  0 ) {
      return maxSoFar;
    }
    for (int i = 0; i <  ch.length-1 ; i++) {

      for (int j = i+1; j < ch.length ; j++) {

        if( ch[i] < ch[j]) {
          swap(ch,i,j);
          String s = new String(ch);
          if( s.compareTo(String.valueOf(maxSoFar)) > 0) {
            maxSoFar = Integer.valueOf(s);
          }

          maxSoFar = findMaximum(ch,k-1,maxSoFar);
          swap(ch,i,j);
        }
      }


    }
    return maxSoFar;
  }

  static  void swap( char ch[], int i, int j ) {
    char t =  ch[i];
    ch[i] = ch[j];
    ch[j] = t;
  }


  static int maxNumber( int num,int k) {

    for (int i = 0; i < k ; i++) {
      num = maxSwap(num);
    }
    return num;
  }

  static int maxSwap(int num) {
    char digits [] = Integer.toString(num).toCharArray();
    int buckets[] = new int [10];

    for (int i = 0; i < digits.length; i++) {
      buckets[digits[i]-'0'] = i;
    }

    for (int i = 0; i <  digits.length; i++) {
      for (int j = 9; j > digits[i] - '0' ; j--) {
        if (buckets[j]  > i) {
          swap(digits, i, buckets[j]);
          return Integer.valueOf(new String(digits));
        }
      }
    }

    return num;

  }



  static int [] maximize(int a [], int k ) {

    int swapsLeft = k ;
    int startIndex = 0;

    while (swapsLeft > 0 || startIndex < a.length) {

      for (int i = startIndex ; i < a.length-1 ; i++) {

        if (a[i] < a[i+1]) {
           int t = a[i];
           a[i] = a[i+1];
           a[i+1] = t;
           swapsLeft --;
           break;
        }
        startIndex++;
      }
    }
    return a;
  }

}
