package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/04/19
 * Time:    9:03 PM
 * https://leetcode.com/problems/minimum-path-sum/
 *
 *
 *   1 4 5
 *   2
 */
public class MinimumPathSum {

  public static void main(String[] args) {

    int grid [][] = {
        {1,3,1},
        {1,5,1},
        {4,2,1}
    };

    System.out.println(minPathSum(grid));

  }

  public static int minPathSum(int[][] grid) {

    for(int i=0; i<grid.length;i++) {
      for(int j=0; j<grid[0].length; j++){
        if (i == 0 && j==0) {
          continue;
        } else if (i == 0 ) {
          grid[i][j] +=  grid[i][j-1];
        } else if (j == 0) {
          grid[i][j] +=  grid[i-1][j];
        } else {
          grid[i][j] =  grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);

        }

      }
    }
    return grid[grid.length-1] [grid[0].length -1];

  }
}
