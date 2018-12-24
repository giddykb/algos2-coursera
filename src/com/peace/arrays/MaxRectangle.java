package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    19/11/18
 * Time:    5:06 PM
 *
 * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * For example: hist=[2,3,1,4,5,4,2]
 */


public class MaxRectangle {

  public static void main(String[] args) {

    int a [] = {2,3,1,4,5,4,2};
    System.out.println(maxArea(a));
  }

  public static int maxArea(int a[]) {
    int maxArea = 0;

    for (int i = 0; i < a.length; i++) {
      int h = a[i];
      maxArea = Math.max(maxArea,h);

      for (int j = i-1; j > 0 ; j--) {
        int width = (i-j+1);
        int minHeight = Math.min(a[j],h);
        maxArea = Math.max(h, width*minHeight);
      }

    }
    return maxArea;
  }
}
