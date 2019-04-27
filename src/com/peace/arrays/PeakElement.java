package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/07/18
 * Time:    2:37 PM
 *
 *

 Given an array of size n, find a peak element in the array. Peak element is the element which is greater than or equal to its neighbors.
 For example - In Array {1,4,3,6,7,5}, 4 and 7 are peak elements. We need to return any one peak element.

 */
public class PeakElement {

  public  static  void main(String [] args) {

    int a [] = {1,2};
    System.out.println("Peak element : " + findPeak(a));
  }

  private  static int findPeak(int  a[]) {
    return  findPeak(a,0,a.length -1);
  }

  private  static int findPeak(int  a[], int lo , int hi) {

    int mid = lo + ( hi - lo)/2 ;

    if( (mid == 0 || a[mid] > a[mid -1]) &&
        (mid == a.length-1 || a[mid] > a[mid+1]) ) {
      return   a[mid] ;
    } else  if (  mid > 0 && a[mid] < a[mid-1]){
      return  findPeak(a,lo,mid-1);
    } else  {
      return  findPeak(a,mid+1,hi);
    }
  }
}
