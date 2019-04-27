package amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    11:05 AM
 */
public class MinimumTimeToRotTomatoes {

  private static  final int EMPTY = 0;
  private static  final int FRESH = 1;
  private static  final int ROTTEN = 2;

  public static void main(String[] args) {
    int grid[][] = {
        {2, 1, 0, 1, 1},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1}
    };
    System.out.println(minTime(grid));
  }


  static int minTime( int[][] grid) {

    int rows =  grid.length;
    int columns = grid[0].length;

    Queue<CellData> queue = new LinkedList<>();

    for (int i = 0; i < rows ; i++) {
      for (int j = 0; j < columns ; j++) {
        if(grid[i][j] == ROTTEN) {
          queue.offer(new CellData(i,j,0));
        }
      }
    }

    int dr[]  = {0, 0, 1, -1};
    int dc [] = {1,-1, 0,  0};
    int possibleMoves = 4;
    int totalMinTime = 0;
    while (!queue.isEmpty()) {
      CellData currentOrange = queue.remove();
      totalMinTime = currentOrange.getTime();
      for (int i=0; i < possibleMoves; i++) {
        int r = currentOrange.i + dr[i];
        int c = currentOrange.j + dc[i];
        if (isValid(r,c,rows,columns) && grid[r][c] == FRESH) {
          grid[r][c] = ROTTEN;
          queue.add(new CellData(r,c,currentOrange.getTime() +1));
        }
      }

    }

    return checkIfAnyFreshExists(grid)? -1 : totalMinTime;
  }

  static boolean checkIfAnyFreshExists(int grid [][]) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == FRESH) return true;
      }
    }
    return false;
  }
  static boolean isValid(int r, int c, int rows, int columns) {
    return r >=0 && r < rows && c >=0 && c < columns;
  }

  @Getter
  @Setter
  private static class CellData {
    int i ;
    int j ;
    int time;
    CellData(int i, int j) {
      this.i = i;
      this.j = j;
    }

    CellData(int i , int j , int time) {
      this(i,j);
      this.time = time;
    }
  }


}
