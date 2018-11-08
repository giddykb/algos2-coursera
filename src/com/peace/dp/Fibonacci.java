package com.peace.dp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    01/11/18
 * Time:    10:44 AM
 */
public class Fibonacci {

  public static void main(String[] args) {
    int n = 50;
    int result = 0;
    long startTime  = System.currentTimeMillis();
    result = recursive(n);
    long endTime  = System.currentTimeMillis();
    System.out.println("recursive timTaken:" + (endTime-startTime) + " result: " + result);


    startTime  = System.currentTimeMillis();
    result = topDown(n);
    endTime  = System.currentTimeMillis();
    System.out.println("topDown  timTaken :" + (endTime-startTime) + " result: " + result);


    startTime  = System.currentTimeMillis();
    result = bottomUp(n);
    endTime  = System.currentTimeMillis();
    System.out.println("bottomUp timTaken: " + (endTime-startTime) + " result: " + result);
  }

  private static int recursive(int n) {
    if (n ==0 || n ==1 ) return n;
    return recursive(n-1) +recursive(n-2);
  }

  private static int topDown(int n) {
    if (n<2) return n;
    int [] cache = new int[n+1];
    Arrays.fill(cache,-1);
    cache[0] = 0;
    cache[1] = 1;
    return topDown(n,cache);

  }

  private static int topDown(int n , int [] cache) {
    if (cache[n] >= 0) return cache[n];
    cache[n] = topDown(n-1, cache) + topDown(n-2, cache);
    return cache[n];
  }

  private static int bottomUp(int n) {
    if ( n== 0 || n ==2) return n;

    int [] cache = new int[n+1];
    cache[0] = 0;
    cache[1] = 1;
    for (int i = 2; i <=n ; i++) {
      cache [i] = cache[i-1] + cache[i-2];
    }
    return cache[n];
  }

}
