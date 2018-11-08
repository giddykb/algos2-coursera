package com.peace.priorityqueues;

import elementory.sorting.QuickSelect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/07/18
 * Time:    3:18 PM
 */

public class MaxPQ <T extends  Comparable<T> > {

  private  T[] keys ;
  private  int capacity;
  private  int size;

  MaxPQ(int capacity){
    keys = (T[]) new Comparable[capacity +1];
    this.capacity = capacity;


  }

  public  boolean isEmpty() {
    return  this.size == 0;
  }

  public  void insert(T t) {
    keys[++size] = t;
    swim(size);

  }
  public T deleteMax(){
    T max = keys[1];
    exch(1,size--);
    sink(1);
    keys[size+1] = null;
    return  max;
  }


  private void sink( int k) {
    while (2*k <= size) {
      int j = 2*k;
      if(j < size && less(j,j+1)) j++;
      if( !less(k,j)) break;
      exch(k,j);
      k = j;
    }
  }

  private void swim(int k) {

    while (k > 1 && less(k/2,k)) {
      exch(k, k/2);
      k = k/2;
    }
  }

  public  boolean less( int i, int j) {
    return  keys[i].compareTo(keys[j]) < 0 ;
  }

  private  void exch(int i, int j) {
    T tmp = keys[i];
    keys[i] = keys[j];
    keys[j] = tmp ;

  }

  public  T max(){
    return  keys[1];
  }
  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }



  public  static  void main( String [] args) {
    File file = new File("data/tinyPQ.txt");
    MaxPQ pq = new MaxPQ(20);
    try {
      Scanner scr = new Scanner(file);
      String s = "";
      while (scr.hasNextLine()) {
        s = scr.next();
        if(!s.equals("-")) pq.insert(s);
        else pq.deleteMax();
      }
      System.out.println(pq.max());

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
