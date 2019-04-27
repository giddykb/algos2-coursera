package com.peace.arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/04/19
 * Time:    3:05 PM
 */
public class SpiralMatrix {
  public static void main(String[] args) {

   int [][] mat = {
        {1, 2, 3,  4},
        {5, 6,  7,8},
        {9,10, 11,12},
    };

 /*  int mat[] [] = {
       { 1, 2, 3 },
       { 4, 5, 6 },
       { 7, 8, 9 }
   };
*/
    prinSpiralOrder(mat);

  }

  public static  void prinSpiralOrder(int mat[][]) {

    int rows = mat.length;
    int columns = mat[0].length;

    int r1 = 0, r2 = rows - 1;
    int c1 = 0, c2 = columns -1;
    StringBuilder result = new StringBuilder();
    while (r1 <= r2 && c1 <= c2) {
      for (int i = c1; i <=c2 ; i++) {
        result.append(mat[r1][i]);
        result.append(" ");
      }
      r1++;
      for (int j = r1; j <=r2 ; j++) {
        result.append(mat[j][c2]);
        result.append(" ");
      }
      c2--;
      if (r1 <= r2 ) {
        for (int k = c2; k >= c1; k--) {
          result.append(mat[r2][k]);
          result.append(" ");
        }
      }
        r2--;
      if(c1 <=c2) {
        for (int l = r2; l >= r1; l--) {
          result.append(mat[l][c1]);
          result.append(" ");
        }
      }

      c1++;
    }

    System.out.println(result.toString());
  }
}
