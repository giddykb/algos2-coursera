package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/04/19
 * Time:    5:54 PM
 */
public class MinimumJumps {
  public static void main(String[] args) {

  }

  public static  int minJumps(int [] arr, int index) {

    if (index == arr.length -1) {
      return 1;
    }

    int remainingLength = arr.length-index;

    if ( arr[index] >= remainingLength) return 1;

    if ( arr[index] ==  0) {
      return Integer.MAX_VALUE;
    }

    int jumps = Integer.MAX_VALUE;

    for (int i = 1; i <= arr[index] ; i++) {
     int temp = minJumps(arr, index + i);

     if(temp != Integer.MAX_VALUE) {
       jumps = Math.min(jumps,1 + temp);
     }

    }

    return jumps;
  }
}
