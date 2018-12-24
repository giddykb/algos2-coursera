package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/12/18
 * Time:    1:38 PM
 */
public class FirstMissingPositive {

  public static void main(String[] args) {

  }


  static int solution(int nums[]) {
    if ( nums.length == 0 ) return 1;

    int idx = 0;

    while (idx < nums.length) {
       int inp =  nums[idx];

       if( inp-1 == idx || inp > nums.length || inp < 0 ) {
         idx++;
       }
       else {
         int tmp = nums[inp-1];
         
       }
    }
    return nums.length + 1;
  }
}
