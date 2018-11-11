package com.peace.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/11/18
 * Time:    12:03 AM
 *
 * Given an array of non negative integers, start from the first element and reach the last by jumping.
 * The jump length can be at most the value at the current position in the array.
 * Optimum result is when you reach the goal in minimum number of jumps.
 *
 * Given array A = {2,3,1,1,4}
  possible ways to reach the end (index list)
  i) 0,2,3,4 (jump 2 to index 2, then jump 1 to index 3 then 1 to index 4)
  ii) 0,1,4 (jump 1 to index 1, then jump 3 to index 4)

 Since second solution has only 2 jumps it is the optimum result.


 */
public class MinimumSteps {

  public static void main(String[] args) {
    int a[] =  {2,3,1,1,4};
    System.out.println(minimumSteps(a,0));
    System.out.println(bottomUp(a));

  }

  public static  int minimumSteps(int a[], int startIndex) {
    if ( startIndex == a.length-1) return  0;
    if( a[startIndex] == 0) return Integer.MAX_VALUE;

    int remainingElements = a.length - startIndex+1;
    if( a[startIndex] > remainingElements) return 1;

    int minJumps = Integer.MAX_VALUE;
    for (int i = 1; i <=a[startIndex]; i++) {
      int jumps = minimumSteps(a, startIndex+i);
      if( jumps != Integer.MAX_VALUE){
        minJumps = Math.min(1+jumps, minJumps);
      }
    }

    return minJumps;
  }

  public static int memoization(int a[]){
    Map<Integer,Integer> cache = new HashMap<>();
    return memoization(a,0,cache);

  }

  public static int memoization(int a[], int startIndex, Map<Integer,Integer> cache){

    if (startIndex == a.length-1) return 0;
    if (a[startIndex] == 0) return Integer.MAX_VALUE;
    if(cache.containsKey(startIndex)) return cache.get(startIndex);

    int remainingLength = a.length - startIndex+1;
    if (a[remainingLength] < a[startIndex]) return 1;

    int minJumps = Integer.MAX_VALUE;
    for (int i = 1; i <=a[startIndex] ; i++) {
      int jumps = memoization(a,startIndex+i,cache);
      if ( jumps != Integer.MAX_VALUE) {
        minJumps = Math.min(minJumps,jumps);
      }
    }
    cache.put(startIndex,minJumps);
    return minJumps;
  }

  public static int bottomUp(int a[]) {

    int [] jumps = new int[a.length];
    Arrays.fill(jumps,Integer.MAX_VALUE);
    jumps[0] = 0;
    int [] result = new int[a.length];
    Arrays.fill(result,Integer.MAX_VALUE);
    result[0] = 0;

    for (int i = 1; i < a.length ; i++) {
      for (int j = 0; j < i ; j++) {
        if (a[j] + j >= i) {
          if ( jumps[i] > jumps[j] +1) {
            jumps[i] = jumps[j]+1;
            result[i] = j;
          }
        }
      }
    }
    return jumps[a.length-1];
  }


}
