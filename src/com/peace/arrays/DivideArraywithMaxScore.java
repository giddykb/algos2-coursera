package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    14/07/18
 * Time:    11:08 PM
 */
public class DivideArraywithMaxScore  {

  public  static  void main(String [] args) {
    int a [] = {4, 1, 0, 1, 1, 0, 1};
    System.out.println(findDivideAndCount(a));
  }

  private  static  int findDivideAndCount(int [] a){
    int totalSum = 0;
    for (int i = 0; i <= a.length - 1 ; i++) {
      totalSum += a[i];
    }
    return findDivideAndCount(a,0,a.length-1, totalSum);
  }

  private  static  int findDivideAndCount(int a[], int lo , int hi,int totalSum){

    if ( lo >=  hi) return  0;
    if (totalSum %2 != 0) return  0;
    int index = lo;
    int leftSum = 0, rightSum = totalSum;
    boolean isEqual  = false;
    do {
        leftSum += a[index];
        rightSum -= a[index];

        if (leftSum == rightSum) {
          isEqual = true;
          break;
        }
        index ++;

    } while (index <= hi);

    if( isEqual ) {
      return  1+ Math.max(findDivideAndCount(a,0,index,leftSum),
                          findDivideAndCount(a,index+1, hi,rightSum));
    }

    return  0;
  }

}
