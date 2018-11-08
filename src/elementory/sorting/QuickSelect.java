package elementory.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/07/18
 * Time:    4:50 PM
 * Find the kth smallest elemet
 * @noinspection ALL
 */
public class QuickSelect {


  public Comparable select( Comparable [] a, int k ) {

    shuffle(a);
    int lo = 0, hi = a.length -1;
    while(lo < hi) {

      int j = partition(a,lo,hi);
      if( j > k)  hi = j-1;
      else if ( j < k) lo = j+1 ;
      else return a[k];

    }

     return a[k];
  }

  private  int partition(Comparable [] a, int lo , int hi) {
    int i = lo, j = hi+1 ;
    while (true) {

      while (less(a[++i],a[lo])) {
          if ( i == hi) break;
      }

      while (less(a[lo],a[--j])) {
        if( j == lo) break;
      }

      if( i >= j) break;
      swap(a,i,j);

    }
    swap(a,lo,j);
    return  j;

  }

  private static  boolean less(Comparable v , Comparable w){
    return  v.compareTo(w) < 0 ;
  }

  private  void shuffle(Comparable [] a) {
    Random rnd = new Random();
    for (int i = a.length; i >1; i--) {
      swap(a,i-1,rnd.nextInt(i));

    }
  }

  private  void swap(Comparable [] a, int i, int j ) {
    Comparable temp =  a[i];
    a[i] =a [j];
    a[j] = temp ;
  }

  public  static  void main(String [] args) {
    File file = new File("data/words.txt");
    try {
      Scanner scr = new Scanner(file);
      String s = "";
      while (scr.hasNextLine()) {
        s += scr.nextLine()+ " ";
      }
      Comparable a [] = s.split(" ");
      QuickSelect  qs = new QuickSelect();
      int k = 1 ;
      Comparable result= qs.select(a,k);
      System.out.println(k+ "th smallest element is " + result);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }





}
