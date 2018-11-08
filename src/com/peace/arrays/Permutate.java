package com.peace.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/07/18
 * Time:    9:34 PM
 * @noinspection ALL
 */
public class Permutate  {
  public  static  void  main(String [] args) {
   int a[] = {1,2,3};
    ArrayList<int []>  results = permutate(a);
    for (int [] result : results) {
      System.out.println( Arrays.toString(result));
    }
  }

  public static ArrayList<int []> permutate(int [] a){
    ArrayList<int[]> results = new ArrayList<>();
    permutate(a,0,results);
    return results;

  }

  private  static  void permutate(int [] a, int start ,ArrayList<int[]> results){

    if( start >= a.length) {
      results.add(a.clone());
    } else {
      for (int i = start; i < a.length; i++) {
          exch(a,start,i);
          permutate(a,start+1,results);
          exch(a,start,i);
      }
    }
  }

  private  static  void exch(int a[], int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

}
