package com.peace.arrays;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    02/12/18
 * Time:    12:28 AM
 */
public class ArraySpliting {

  public static void main(String[] args) {

    //int inp [] = {4,1,0,1,1,0,1};
    int inp [] = {2,2,2,2};
   //System.out.println(arraySplitting(inp));

    String t = "4514826";
    String [] values = t.split(",");
    System.out.println(Arrays.toString(values));

  }

  static int  arraySplitting(int [] arr) {
    return sum(arr, 0 , arr.length-1 );
  }

  static int sum (int arr[] , int i, int j ) {
   if ( i == j || i > j) return  0;

   int sum  = 0 ;

   for (int k = i; k <=j ; k++) {
      sum  += arr[k];
    }

    int rightSum = 0;
    int leftSum = 0;
    int count = 0;

    for (int k = i; k <=j ; k++) {
      leftSum +=  arr[k];
      rightSum = sum  - leftSum;

      if( leftSum == rightSum ) {
        int len1 = k-i +1;
        int len2 = j-k;

        if ( len1 > len2) {
          j = k;
        } else{
          i = k+1;
        }
        count = 1 + sum(arr,i,j);

      }
    }
    return count;
  }

}
