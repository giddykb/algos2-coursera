package elementory.sorting;

import com.peace.directed.BreadthFirstDirectedPaths;
import com.peace.directed.Digraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    02/07/18
 * Time:    1:45 PM
 * @noinspection ALL
 */
public class QuickSort  {

  public static  void sort(Comparable a[]) {
    shuffle(a);
    sort(a,0,a.length-1);
  }

  private   static  void  sort(Comparable [] a, int lo,  int hi) {

    if( hi <= lo) return;
    int j = partition(a,lo,hi);
    sort(a,lo,j-1);
    sort(a,j+1,hi);
  }

  private static  int  partition(Comparable a[] , int lo,int hi) {
    int i = lo,  j= hi+1;
    while (true) {

      while (less(a[++i],a[lo]))
        if (i == hi) break;

      while (less(a[lo],a[--j]))
        if(j == lo) break;

      if( i >= j ) break;
      exch(a,i,j);
    }
    exch(a,lo,j);
    return  j;

  }

  // On equal keys this sorting method is efficient
  private  static void  sortEfficient(Comparable [] a, int lo,  int hi) {

    if( hi <= lo) return;

    int lt  = lo, gt = hi;
    int i = lo ;
    Comparable v = a[lo];

    while (i <= gt) {

       int cmp = v.compareTo(a[i])  ;

       if (cmp <  0) exch(a ,lt++,i++);
       else if(  cmp > 0) exch( a, i,gt--);
       else i++;

    }
    sort(a, lo, lt-1);
    sort(a,gt+1, hi);

  }


  private static  boolean less(Comparable v , Comparable w){
    return  v.compareTo(w) < 0 ;
  }

  private  static  void exch(Comparable a[] , int i , int j) {
      Comparable temp = a[i];
      a[i] = a[j];
      a[j] = temp;
  }

  public  static  void shuffle(Comparable a[]) {
    Random rand = new Random();
    for (int i = 0; i < a.length ; i++) {
      int r =  rand.nextInt(i+1);
      exch( a,i,r);
    }
  }

  public  static void main(String [] args) {
    File file = new File("data/words.txt");
    try {
      Scanner scr = new Scanner(file);
      String s = "";
      while (scr.hasNextLine()) {
         s += scr.nextLine()+ " ";
      }
      Comparable a [] = s.split(" ");
      //Comparable a []  = {21,10,5,21,21,42,100};
      sort(a);
      System.out.println(Arrays.toString(a));


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}
