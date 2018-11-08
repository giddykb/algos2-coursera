package com.peace.dp;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    02/11/18
 * Time:    10:00 AM
 */
public class CoinChange {
  public static void main(String[] args) {
    int amount = 4;
    int coins[] = {1,2,3,5,7};
    int result = 0;
    long startTime  = System.currentTimeMillis();
    result = count(coins,   amount, coins.length-1);
    long endTime  = System.currentTimeMillis();
    System.out.println("recursive timTaken:" + (endTime-startTime) + " result: " + result);

    HashMap<String,Integer> lookUp = new HashMap<>();
    startTime  = System.currentTimeMillis();
    result = topDown(coins,   amount, coins.length-1,lookUp);
    endTime  = System.currentTimeMillis();
    System.out.println("topDown timTaken:" + (endTime-startTime) + " result: " + result);

  }


  private static int count(int [] coins, int amount,int n) {
    if ( amount == 0) return  1;
    if ( amount < 0 || n < 0) return  0;

    int incl = count(coins, amount-coins[n], n);
    int excl = count(coins, amount, n-1);
    return incl +excl;

  }
/*
* n - no of elements remaining
* */
  private static  int topDown(int [] coins, int amount, int n, HashMap<String,Integer> lookUp) {
    if ( amount == 0) return  1;
    if ( amount < 0 || n < 0 ) return 0;

    String key = n+"|"+amount;
    if (!lookUp.containsKey(key)) {
      int incl = topDown(coins, amount - coins[n], n, lookUp);
      int excl = topDown(coins,amount, n-1, lookUp);
      lookUp.put(key, incl +excl);
    }

    return lookUp.get(key);
  }



}
