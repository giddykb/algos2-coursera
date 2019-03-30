package dcp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/12/18
 * Time:    1:16 AM
 *
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.


 */
public class PaintHouse {

  public static void main(String[] args) {

    int cost[][] = {
        {4,0,3},
        {8,3,8},
        {4,5,0},
        {3,4,4},
        {8,8,0}
    };

    System.out.println(minCost(cost));
    System.out.println(minCostSolution(cost));

  }

  static int minCost(int [][] cost) {
    if (cost.length == 0) return 0;
    for (int i = 1; i < cost.length ; i++) {
      cost[i][0] += Math.min(cost[i-1][1],cost[i-1][2]);
      cost[i][1] += Math.min(cost[i-1][0],cost[i-1][2]);
      cost[i][2] += Math.min(cost[i-1][1],cost[i-1][0]);
    }
    int m =cost.length -1;
    return Math.min(cost[m][0],Math.min(cost[m][1],cost[m][2]));
  }

  static int minCostSolution(int [][] cost) {
    if (cost.length == 0) return 0;

    for (int i = 1; i < cost.length; i++) {
      for (int j = 0; j < 3 ; j++) {
        cost[i][j] += Math.min(cost[i-1][(j+1)%3],cost[i-1][(j+2)%3]);
      }
    }

    int m = cost.length-1;
    return Math.min(cost[m][0],Math.min(cost[m][1],cost[m][2]));

  }
}
