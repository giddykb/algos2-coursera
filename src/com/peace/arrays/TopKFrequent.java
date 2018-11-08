package com.peace.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/07/18
 * Time:    12:50 AM
 */
public class TopKFrequent {

  public static void main (String [] args) {

    int arr [] =  {1,1,1,2,2,3,3,3,1,4,4,4,4} ;
    int k = 2;
    List<Integer> res = methodOne(arr, k);
    System.out.println(res);
  }

  public static List<Integer> methodOne(int arr[],int k) {
    Map<Integer,Integer>  frequencyMap = new HashMap<>();
    for (int integer : arr) {
      frequencyMap.put(integer,frequencyMap.getOrDefault(integer,0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer> > maxHeap =  new PriorityQueue<>(
        (a,b) -> (b.getValue() - a.getValue()));

    for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
         maxHeap.add(entry);
    }

    List<Integer> res = new ArrayList<>();

    while (res.size() < k ) {
        res.add(maxHeap.poll().getKey());
    }

    return  res;

  }


  public  static  List<Integer> topKFrequent(int [] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
    }

    List<Integer> [] buckets = new List[nums.length + 1];

    for (Integer key : frequencyMap.keySet()) {
      int frequency  = frequencyMap.get(key);
      if( buckets[frequency] == null) {
        buckets[frequency] = new ArrayList<>();
      }
      buckets[frequency].add(key);
    }
    List<Integer> res = new ArrayList<>();

    for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
      if( buckets[i] != null){
        res.addAll(buckets[i]);
      }
    }
    return  res;

  }

}
