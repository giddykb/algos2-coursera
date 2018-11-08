package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/07/18
 * Time:    9:24 AM
 *
 * Given a set, find out if it can be partitioned into two disjoint subsets
 * such that sum of the elements in both these subsets is equal.
 * Intersection of disjoint sets should be null and union should be the complete set.
 * {7,5,3,5}   {7,3} & {5,5}

 */
public class SetPartition {

  public  static  void main(String [] args) {

    int a [] = {7,5,3,5};
    int total = 10;
    System.out.println(isPartitionExist(a,total));
  }

  public static boolean isPartitionExist(int [] a, int total) {

    int numRows = total + 1;
    int numColumns = a.length + 1;

    boolean solution[] [] = new boolean[numRows] [numColumns] ;
    for (int j = 0; j <numColumns ; j++) {
      solution[0][j] = true;
    }
    for (int i = 1; i < numRows; i++) {
      solution[i][0] = false;
    }

    for (int j = 1; j < numColumns; j++) {
      for (int i = 0; i < numRows ; i++) {

         if (solution[i][j-1]) {
             solution [i ][j]  = true;
             if ( i + a[j-1] < numRows) {
               solution [i + a[j-1]] [j]= true;
             }
         } else  if (!solution[i][j]) {
           solution [i][j] = false;
         }
      }
    }

    return solution[numRows-1] [numColumns-1];
  }
}
