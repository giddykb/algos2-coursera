package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/03/19
 * Time:    10:42 PM
 *
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

  public static void main(String[] args) {
    int m =  7 ;
    int n  = 3;
    System.out.println(topDown(m,n));

  }

  public static int uniquePaths( int m, int n) {
    if(m < 0 || n < 0) return 0;
    if (m-1 == 0 && n-1 == 0) return 1;
    return uniquePaths(m-1, n) + uniquePaths(m, n-1);
  }

  public static int topDown(int m, int n) {
    int cache [][] = new int [m+1][n+1];
    return topDown(m,n,cache);
  }

  public static int topDown(int m, int n, int cache[][]) {
    if(m < 0 || n < 0) return 0;
    if (m-1 == 0 && n-1 == 0) return 1;
    if (cache[m][n] != 0) return cache[m][n];
    cache[m][n] = topDown(m-1,n,cache) + topDown(m,n-1,cache);
    return cache[m][n];
  }
}

