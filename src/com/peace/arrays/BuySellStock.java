package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/04/19
 * Time:    9:43 PM
 */
public class BuySellStock {
  public static void main(String[] args) {
    int prices[] = {7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
  }

  public static int maxProfit(int[] prices) {
    if (prices.length == 0 ) {
      return 0;
    }
    int minSoFar = prices[0];
    int maxSoFar = prices[0];
    int profit = 0;
    for( int i = 1; i< prices.length; i++) {
      maxSoFar = Math.max(maxSoFar, prices[i]);
      if (prices[i] < minSoFar) {
        minSoFar = prices[i];
        maxSoFar = 0;
      }
      profit= Math.max(profit,maxSoFar -minSoFar);
    }
    return profit;
  }
}
