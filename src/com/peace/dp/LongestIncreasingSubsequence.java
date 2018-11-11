package com.peace.dp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/11/18
 * Time:    1:17 AM
 */
public class LongestIncreasingSubsequence {

  public static void main(String[] args) {

    //int a [] = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
    int a [] = {3,4,-1,0,6,2,3};

    System.out.println(findSubsequence(a));

  }


  public static int findSubsequence( int a[]) {
    int LIS [] = new int[a.length];
    Arrays.fill(LIS,1);
    int max = 0;
    for (int i = 1; i < a.length ; i++) {
      for (int j = 0; j < i ; j++) {
        if ( a[i] > a[j]) {
          LIS[i] = Math.max(LIS[i],1+LIS[j]);
        }
      }
    }

    int result = 0;
    int index = 0;
    for (int i = 0; i < LIS.length ; i++) {
      if ( LIS[i] > result) {
        result = LIS[i];
        index = i;
      }
    }

    // print result ;
    int res = result-1;
    String path = a[index]+"";
    for (int i = index-1; i >=0 ; i--) {
      if ( LIS[i] == res) {
        path =  a[i] + " " + path;
        res--;
      }
    }
    System.out.println("Longest sequence path " +  path);
    return result;

  }
}
