package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/11/18
 * Time:    5:13 PM
 */
public class SquareSubMatrix {

  public static void main(String[] args) {
    int m [][] = {
        {1,1,1,1},
        {1,1,1,1},
        {1,1,0,1},
        {1,1,1,1}
    };

    /*int m [][] = {
        {1,1},
        {0,1}
    };*/

    System.out.println("Recursive Maximum square sub matrix::: " + squareSubMatrix(m));

    System.out.println("TopDown Maximum square sub matrix::: " + topDown(m));

    System.out.println("BottomUp Maximum square sub matrix::: " + bottomUp(m));
  }

  private static int squareSubMatrix( int m [][]){

    int rows = m.length;
    int cols = m[0].length;

    int max = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if ( m[i][j] == 1) {
          max = Math.max(max,squareSubMatrix(m,i,j));
        }
      }
    }

    return max;
  }

  private static int squareSubMatrix(int m [][], int i , int j ) {
    if ( i == m.length || j == m[0].length) return 0;
    if (m[i][j] == 0) return 0;
    return  1 + Math.min(Math.min(
        squareSubMatrix(m,i,j+1),squareSubMatrix(m,i+1,j)),
                         squareSubMatrix(m,i+1,j+1));

  }

  private static int topDown(int m[][]) {

    int rows = m.length;
    int cols = m[0].length;

    int cache [] [] = new int [rows][cols];

    int max = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if ( m[i][j] == 1 ) {
          max = Math.max(max,topDown(m,i,j,cache));

        }
      }
      
    }
    return max;
  }

  private static int topDown(int m [][], int i, int j, int [][] cache) {

    if ( i == m.length || j == m[0].length) return  0;
    if ( m[i][j] == 0) return 0;
    if ( cache [i][j] > 0) return cache[i][j];
    cache[i][j] = 1 + Math.min(
        Math.min(topDown(m,i,j+1,cache),topDown(m,i+1,j,cache)),
        topDown(m,i+1,j+1,cache));

    return cache[i][j];

  }

  private static int bottomUp(int m [][]){
    int rows = m.length;
    int cols = m[0].length;

    int cache [] [] = new int [rows][cols];
    int max = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols ; j++) {

        if ( i == 0 || j == 0) {
          cache[i][j] = m[i][j];
        }

        else if ( m[i][j] == 1) {
          cache[i][j] =  1 +
              Math.min(
                  Math.min(cache[i-1][j], cache[i][j-1]),
                  cache[i-1][j-1]);
        }

        max = Math.max(max, cache[i][j]);

      }

    }

    return max;
  }
}
