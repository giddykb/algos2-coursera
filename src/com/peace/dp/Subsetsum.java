package com.peace.dp;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/07/18
 * Time:    10:34 AM
 *
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * {2, 3, 7, 8};
 * @noinspection ALL
 */
public class Subsetsum {

  public  static  void main(String [] args) {

    int a [] = { 7, 3, 2, 5, 8 };
    //{7,5,3,5};
    int total = 18;
    System.out.println(bottomUp(a, total));
    //System.out.println(topDownRecursive(a, total));
    //System.out.println(partition(a));
  }


  public static  boolean topDownRecursive(int a [], int total) {
    int solution [] = new int [a.length];
    return topDownRecursive(a, total, 0,solution);
  }

  public static  boolean topDownRecursive(int a [], int total, int idx,int solution [])  {

    if ( total == 0) {
      for (int i = 0; i < solution.length; i++) {
        if ( solution[i] == 1) {
          System.out.print(a[i] + " ");
        }
      }
      System.out.println();
      return true;
    }
    if ( idx == a.length || total < 0 ) return false;

    solution[idx] = 1;
    boolean include = topDownRecursive(a, total - a[idx], idx+1 ,solution);
    solution[idx] = 0;
    boolean exclude = topDownRecursive(a,total, idx+1, solution);
    return include || exclude ;

  }

  public static  boolean topDownMemozation(int a [] , int total) {
    int solution [] = new int [a.length];
    HashMap<String, Boolean> cache = new HashMap<>();
    return topDownMemozation(a,total,0,solution,cache);

  }

  public static  boolean topDownMemozation(int a [] , int total,int idx, int solution[],  HashMap<String, Boolean> cache ) {

    if ( total == 0 ) {
      for (int i = 0; i < solution.length; i++) {
        if ( solution [i] == 1) {
          System.out.print(a[i] + " ");
        }
      }
      System.out.println();
    }

    if ( idx == a.length || total < 0 ) return false;

    String key = idx + "|" + total;

    if (!cache.containsKey(key)) {
      solution[idx] = 1;
      boolean include = topDownMemozation(a, total - a[idx], idx + 1, solution, cache);
      solution[idx] = 0;
      boolean exclude = topDownMemozation(a, total, idx + 1, solution, cache);
      cache.put(key, include || exclude);
    }
    return  cache.get(key) ;

  }

  public  static boolean bottomUp( int a [], int total) {
    boolean T[][] = new boolean [a.length + 1] [total + 1];
    for (int i = 0; i < T.length; i++) {
      T[i][0] = true;
    }

    for (int i = 1; i < T.length; i++) {
      for (int j = 0; j < T[0].length; j++) {
        if (a[i-1] > j) {
          T[i][j] = T[i-1] [j];
        } else {
          T[i][j] = T[i-1] [j] || T[i-1][j-a[i-1]];
        }
      }
    }
    printsolution(T,a);
    return T[a.length][total];
  }

  private static  void printsolution(boolean T[][], int a []) {

    if (!T[a.length][T[0].length-1]) return;

    int i = a.length;
    int j = T[0].length-1;

    while (j > 0) {

      while ( i > 0 && T[i-1][j]) {
        i = i-1;
      }
      System.out.println( a[i-1]);
      j = j - a[i-1];
      i = i-1;

    }

  }

  public static boolean subSetSum(int a[] , int total ) {
    int numRows = a.length + 1;
    int numColumns =  total + 1;

    boolean solution[][] = new boolean[numRows][numColumns];

    for (int i = 0; i < numRows ; i++) {
        solution[i][0] = true;
    }

    for (int i = 1; i < numRows; i++) {
      for (int j = 1; j < numColumns ; j++) {
        if ( j - a[i-1] >= 0 ) {
          solution [i] [j] = solution [i-1] [j] || solution [i-1] [j - a[i-1]] ;
        } else {
          solution [i] [j] = solution [i-1] [j];
        }

      }

    }

    return  solution[numRows - 1 ] [numColumns - 1 ];
  }

  public  static boolean partition(int [] arr) {

   int sum = Arrays.stream(arr).sum();
   if ( sum % 2  != 0) return  false;

   sum = sum /2 ;
   boolean solution [] [] = new boolean[arr.length +1][ sum + 1 ];

    for (int i = 0; i <= arr.length  ; i++) {
      solution[i][0] = true;
    }

    for (int i = 1; i <= arr.length ; i++) {
      for (int j = 1; j <= sum ; j++) {
        if ( j - arr[i-1] >= 0) {
          solution [i] [j] = solution [i-1] [j] || solution[i-1] [j - arr[i-1] ] ;
         } else {
          solution[i] [j] = solution [i-1] [j];
        }

      }

    }

  return  solution[arr.length][sum];
  }

}
