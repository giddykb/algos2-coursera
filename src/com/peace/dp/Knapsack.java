package com.peace.dp;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/11/18
 * Time:    8:18 PM
 */
public class Knapsack {

  public static void main(String[] args) {

    Item item1 = new Item(2,6);
    Item item2 = new Item(2,10);
    Item item3 = new Item(3,12);

    Item[] items = {item1,item2,item3};
    int capacity = 10;
    System.out.println(knapsack(items,capacity));
    System.out.println(topDown(items,capacity));
    System.out.println(bottomUp(items,capacity));
    System.out.println(bottomUpOptimal(items,capacity));

  }

  private static  int knapsack(Item[] items, int capacity) {
    return knapsack(items,capacity,0);
  }

  private static  int knapsack(Item[] items, int capacity, int index) {

    if ( index == items.length) return  0;
    if( capacity - items[index].getWeight() < 0 ) {
      return knapsack(items,capacity,index+1);
    }
    int value = items[index].getValue();
    return Math.max(
        value + knapsack(items,capacity - items[index].getWeight(),index+1),
                    knapsack(items,capacity,index+1));
  }


  private  static int topDown(Item [] items, int capacity) {
    HashMap<Integer, Map<Integer,Integer>>  cache = new HashMap<>();
    return topDown(items, capacity, 0,cache);
  }

  private static int topDown( Item [] items, int capacity, int index,
                              HashMap<Integer, Map<Integer,Integer>>  cache) {

    if ( index == items.length) return 0;

    if (!cache.containsKey(index)) {
      cache.put(index, new HashMap<Integer,Integer>());
    }
    Integer cached = cache.get(index).get(capacity);
    if ( cached != null) return cached;
    Integer maxVal = 0;
    if ( capacity - items[index].weight < 0)  {
      maxVal = topDown(items, capacity, index+1, cache);
    }
    else {
      maxVal = Math.max(
          items[index].value + topDown(items, capacity - items[index].weight, index + 1, cache),
          topDown(items, capacity, index + 1, cache));
    }
    cache.get(index).put(capacity,maxVal);
    return maxVal;
  }

  private static  int bottomUp(Item[] items, int capacity) {
    int [][] cache = new int [items.length + 1][ capacity +1];

    for (int i = 1; i <= items.length ; i++) {
      for (int j = 0; j <= capacity ; j++) {
        if (j - items[i-1].weight < 0) {
          cache[i][j] = cache[i-1][j];
        } else {
          cache[i][j] = Math.max(cache[i-1][j],items[i-1].value + cache[i-1][j- items[i-1].weight]);
        }
      }
    }
    return cache[items.length][capacity];
  }

  private static  int bottomUpOptimal(Item[] items, int capacity) {
    int [] cache = new int [capacity+1];
    for (Item item: items) {
      int [] newCache = new int [capacity+1];
      for (int i = 0; i <=capacity ; i++) {
        if (i - item.weight  < 0)  {
          newCache[i] = cache[i];
        }
        else {
          newCache[i] = Math.max(cache[i], item.value + cache[i - item.weight]);
        }
      }
      cache = newCache;
    }
    return cache[capacity];
  }
}



@Getter
@Setter
class Item{
   int weight;
   int value;


  Item(int weight, int value){
  this.weight = weight;
  this.value = value;
  }
}