package com.peace.dp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    08/11/18
 * Time:    10:24 PM
 *
 * Given a rod of length n inches and a table of prices pi, i=1,2,…,n,
 * write an algorithm to find the maximum revenue rn obtainable by cutting up the rod and selling the pieces.
 * for rod of length: 4
 * Ways to sell :
 •	selling length : 4  ( no cuts) , Price: 9
 •	selling length : 1,1,1,1  ( 3 cuts) , Price: 4
 •	selling length : 1,1,2  ( 2 cuts) , Price: 7
 •	selling length : 2,2  ( 1 cut) , Price: 10
 •	selling length : 3, 1  ( 1 cut) , Price: 9

 Best Price for rod of length 4: 10

 */
public class RodCutting {

  public static void main(String[] args) {
    int a [] = {1,5,8,9,10,17,17,20,24,30};
    int length = 8;
    //System.out.println(profit(a,length));
    System.out.println(bottomUp(a,length));

  }


  public static int bottomUp(int price[], int length) {
    int T[] = new int[length+1];

    for (int i = 1; i <=length ; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        max = Math.max(max,price[j] + T[ i-(j+1)]);
        T[i] = max;
      }
    }
    return T[length];
  }
  public static  int profit(int price[], int length,int cache[] ){
    if ( length <= 0 ) return 0;
    if (cache[length-1] != -1) return cache[length-1];
    int max =  -1;

    for (int i = 0; i < length; i++) {
      max = Math.max(max, price[i] + profit(price, length-(i+1),cache));
      cache[length-1] = max;
    }
    return cache[length-1];
  }

  public static  int profit(int price[], int length ) {
    int cache [] = new int [length] ;
    Arrays.fill(cache, -1);
    return profit(price,length,cache);
  }

}

