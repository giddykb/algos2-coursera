package com.peace.priorityqueues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/07/18
 * Time:    7:05 PM
 */
public class MinPQ<Key> implements Iterable<Key> {
    private  Key [] pq;
  private int N;
  private Comparator<Key> comparator;

  MinPQ(int initialCapacity){
    pq = (Key[])new Object[initialCapacity];
  }
  MinPQ(int initialCapacity, Comparator comparator) {
    this(initialCapacity);
    this.comparator = comparator;
  }

  MinPQ(Key[] keys) {
    N = keys.length;
    pq =  (Key[]) new Object[N+1];
    for (int i = 0; i < N ; i++) {
      pq [i+1] = keys[i];
    }
    for (int i = N/2; i >=1 ; i--) {
      sink(i);
    }
  }

  public  void insert(Key x) {
    if( N == pq.length -1 ) resize(2*N);
    pq[++N] = x;
    swim(N);
    assert  isMinHeap();
  }


  public  Key deleteMin(){
    Key min = pq[1];
    exch(1,N--);
    sink(1);
    pq[N+1] = null;
    return  min;
  }

  private  void swim(int k) {
    while (k > 1 && greater(k/2, k)) {
      exch(k,k/2);
      k = k/2;
    }
  }

  private  void sink( int k) {
    while ( 2*k <= N) {
      int j = 2*k;
      if( j < N && greater(j,j+1)) j++;
      if( !greater(k,j)) break;
      exch(k,j);
      k = j;
    }
  }

  public Key min(){
    if( isEmpty()) throw  new NoSuchElementException("Priority queue underflow");
    return  pq[1];
  }

  public  void resize( int capacity){
    assert  capacity > N;
    Key t [] = (Key[]) new Object[capacity];
    for (int i = 1; i <=N; i++) {
      t[i] = pq [i];
    }
    pq = t;
  }

  public  void exch(int i, int j){
    Key t = pq[i];
    pq[i] = pq[j];
    pq[j] = t ;

  }
  public boolean greater( int i, int j) {
    if( comparator == null) {
      return  ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
    }
    else {
      return  comparator.compare(pq[i], pq[j]) > 0;
    }
  }

  private   boolean isMinHeap(){
    return  isMinHeap(1);
  }

  private  boolean isMinHeap(int k) {
    if( k > N) return  true;
    int left = 2*k;
    int right = 2*k +1;
    if( left <=N  && greater(k,left)) return  false;
    if( right <= N && greater( k, right)) return  false;
    return  isMinHeap(left) && isMinHeap(right);

  }

  public  boolean isEmpty(){ return  N == 0;}
  public int size(){ return  N; }

  MinPQ(){
    this(1);
  }
  @Override
  public Iterator<Key> iterator() {
    return new HeapIterator();
  }

  public  Key [] keys() {
    return  pq;
  }

  private  class  HeapIterator implements  Iterator <Key> {

    private  MinPQ<Key> copy;
    HeapIterator() {
      if (comparator == null) copy = new MinPQ<Key>(size());
      else  copy = new MinPQ<Key>(size(),comparator);
      for (int i = 1; i < pq.length ; i++) {
        copy.insert(pq[i]);
      }
    }
    @Override
    public boolean hasNext() {
      return !copy.isEmpty();
    }

    @Override
    public Key next() {
      if(copy.isEmpty())  new NoSuchElementException("priority queue undeflow");
      return copy.deleteMin();
    }

  }

}
