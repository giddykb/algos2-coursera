package com.peace.dp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    02/11/18
 * Time:    3:59 PM
 */
public class MinimumCoins {

  public static void main(String[] args) {
    int coins [] = {7,2,3,6};
    int amount = 14;

    System.out.println(minCoins(coins,amount));
    //System.out.println(topDown(coins,amount));
    //System.out.println(bottomUp(coins,amount));
  }


  private static int minCoins(int [] coins, int amount) {
    if (amount == 0) return 0;
    if( amount < 0)  return Integer.MAX_VALUE;

    int minCoins = Integer.MAX_VALUE;
    for (int i = 0; i <coins.length ; i++) {
      if (amount - coins[i] >= 0) {
        int result = minCoins(coins, amount - coins[i]);
        if (result != Integer.MAX_VALUE) {
          minCoins = Integer.min(result + 1, minCoins);
        }
      }
    }
    return minCoins;
  }

  private static int topDown( int[] coins , int amount) {
    int cache[] = new int [amount + 1];
    Arrays.fill(cache,-1);
    return topDown(coins,amount, cache);
  }


  private static int topDown( int[] coins , int amount, int cache[]) {
    if (amount == 0) return 0;
    if ( cache[amount] >= 0) return cache[amount];
    if (amount < 0) return Integer.MAX_VALUE;
    Integer minCoins = Integer.MAX_VALUE;

    for (int coin: coins) {
      if (amount - coin >= 0) {
        int currMin = topDown(coins, amount-coin, cache);
          minCoins = Integer.min(currMin + 1, minCoins);
          cache[amount] = minCoins;
        }

    }

    return cache[amount];
  }

  private static int  bottomUp(int[] coins , int amount) {
    int T[] = new int [amount + 1];
    int R[] = new int [amount + 1];
    Arrays.fill(T,Integer.MAX_VALUE-1);
    Arrays.fill(R,-1);
    T[0] =0;

    for( int i = 0 ; i < coins.length; i++) {
      for (int j = 0; j <= amount; j++) {
          if ( j-coins[i] >=0 && ( T[j-coins[i]] +1 < T[j]) ) {
            T[j] = Math.min(T[j], 1+T[j-coins[i]]);
            R[j] = i;
          }
        }
    }
    printCombination(R,coins);

    return T[amount];
  }

  private static void printCombination(int R[], int []coins){
    if ( R[R.length -1] == -1) {
      System.out.println("No solution possible");
    }
    int start = R.length -1;
    while ( start > 0 ) {
      int j = R[start];
      System.out.print( coins[j] +" ");
      start = start - coins[j];
    }
    System.out.println("\n");

  }
}
