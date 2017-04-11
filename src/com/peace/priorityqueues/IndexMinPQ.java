package com.peace.priorityqueues;

import java.util.Arrays;

/**
 * Created by girishkumarbanda on 31/03/2017 AD.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {

    private Key [] keys ;
    private  int [] pq; // index of the key in heap position i
    private  int qp[]; // heap position of the key  with index i
    private  int maxN;
    private  int N ;

    IndexMinPQ(int maxN){
        this.maxN =maxN;
        keys = (Key []) new Comparable[maxN+1];
        pq = new int [maxN+1];
        qp = new int [maxN+1];
        Arrays.fill(qp,-1);

    }
    public boolean isEmpty(){
        return N==0;
    }

    public  boolean contains(int i){
        if(i<0 || i>=maxN) throw  new IndexOutOfBoundsException();
        return  qp[i] !=-1;
    }

    public  int size(){
        return  N;
    }

    public void insert(int i,Key key){
        if(i<0 || i>=maxN) throw  new IndexOutOfBoundsException();
        if(contains(i)) throw new IllegalArgumentException("Index is already in priority queue");
        N++;
        keys[i] =key;
        pq[N] = i;
        qp[i] =N;

        swim(N);

    }

    private void swim(int k) {
        while(k>1  && greater(k/2,k)){
            exch(k/2,k);
            k =k/2;
        }
    }



    private  boolean greater( int i,int j){
        return keys[i].compareTo(keys[j]) >0 ;
    }

    private  void exch(int i,int j){
        Key t = keys[i];
        keys[i]= keys[j];
        keys[j]=t;
    }




}
