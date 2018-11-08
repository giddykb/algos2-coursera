package com.peace.priorityqueues;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    19/07/18
 * Time:    11:13 AM
 */
public class TopKelements {

  public  static  void main(String [] args) {
    Integer arr[] = new Integer[]{1, 23, 12, 9,
        30, 2, 50};
    int k = 3 ;
    Object []  res = findTopKelements(arr, k);
    Integer []  results = Arrays.asList(res).toArray(new Integer[res.length]);
    System.out.println(Arrays.toString(results));
  }

  private  static  Object [] findTopKelements( Integer arr[] , int k ) {
    int res [] = new int[k];
    //MinPQ<Integer> pq = new MinPQ(arr);
    MinPQ<Integer> pq = new MinPQ(k);

    for (int i = 0; i < arr.length; i++) {
        if (pq.size() < k ) pq.insert(arr[i]);
        else if ( pq.size() == k && arr[i]> pq.min()) {
          pq.deleteMin();
          pq.insert(arr[i]);
        }
    }
      return  pq.keys();
  }




}
