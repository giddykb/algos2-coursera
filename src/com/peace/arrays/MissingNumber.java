package com.peace.arrays;

import java.util.BitSet;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/10/18
 * Time:    7:29 PM
 */
public class MissingNumber {

  public static void main(String[] args) {
    int a [] = {1,2,4,5};
    bitSetSolution(a,5);

  }


  private static void solution(int a[],int n) {

    int sum = 0 ;
    for (int i = 0; i <a.length ; i++) {
      sum += a[i];
    }
    int totalSum = n*(n+1)/2;
    System.out.println("Missing number solutionOne :::"+ (totalSum - sum));
  }


  private  static void bitSetSolution(int a[], int count) {
    int missingCount = count - a.length;
    BitSet bitSet = new BitSet(count);

    for (int num: a) {
      bitSet.set(num-1);
    }

    int lastMissingIndex = 0;

    for (int i = 0; i < missingCount ; i++) {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex);
    }

  }


}
