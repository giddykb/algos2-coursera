package dcp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    10:54 PM
 *
 *
 *
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 Given this matrix, a start coordinate, and an end coordinate,
 return the minimum number of steps required to reach the end coordinate from the start.
 If there is no possible path, then return null. You can move up, left, down, and right.
 You cannot move through walls. You cannot wrap around the edges of the board.
 For example, given the following board:
 [[f, f, f, f],
 [t, t, f, t],
 [f, f, f, f],
 [f, f, f, f]]
 and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

 */

@Getter
@Setter
public class ShortestPathInMaze {

  static boolean maze [][]= new boolean [][] {
      { false, true, false, false, false, false, true, false, false, false },
      { false, true, false, true, false, false, false, true, false, false },
      { false, false, false, true, false, false, true, false, true, false },
      { true, true, true, true, false, true, true, true, true, false },
      { false, false, false, true, false, false, false, true, false, true },
      { false, true, false, false, false, false, true, false, true, true },
      { false, true, true, true, true, true, true, true, true, false },
      { false, true, false, false, false, false, true, false, false, false },
      { false, false, true, true, true, true, false, true, true, false }
  };
  static int rows = maze.length;
  static int columns = maze[0].length;

  public static void main(String[] args) {
    Point source = new Point(0, 0);
    Point dest = new Point(3, 4);
    System.out.println(findShortestPath(maze,source,dest));
  }

  static int findShortestPath(boolean maze [][], Point source, Point destination) {

    if (maze[source.x][source.y] || maze[destination.x] [destination.y]){
      return -1;
    }

    boolean[][] isVisited = new boolean[maze.length][maze[0].length];
    Queue<PointDist> pointDistQueue = new LinkedList<>();
    pointDistQueue.add(new PointDist(source, 0));
    isVisited[source.x][source.y] = true;

    int xDirections [] = {0,0,-1,1 };
    int yDirections [] = {-1,1,0,0};
    int possibleMoves = xDirections.length;


    while (!pointDistQueue.isEmpty()) {
      PointDist currNode = pointDistQueue.remove();

      if (currNode.getPoint().x == destination.x && currNode.getPoint().y == destination.y) {

        return currNode.getDistance();
      }

      for (int i = 0; i < possibleMoves ; i++) {

        int row = xDirections[i] + currNode.getPoint().x;
        int col = yDirections[i] +currNode.getPoint().y;

        if(isValidMove(row, col) && !maze[row][col] && !isVisited[row][col]) {
          isVisited[row][col] = true;
          int dist = currNode.getDistance()+1;
          Point p = new Point(row, col);
          pointDistQueue.add(new PointDist(p, dist,currNode));
        }
      }
    }
    return -1;
  }

  public void  printPath() {

  }


  public static boolean isValidMove( int i , int j) {
    return i>=0 && i< rows && j>=0 && j < columns;
  }


  @Getter
  @Setter
  @ToString
  private static class PointDist {
    Point point;
    int distance;
    PointDist prevPoint;

    PointDist(Point p1, int distance) {
      this.point = p1;
      this.distance  = distance;
    }

    PointDist(Point p1, int distance, PointDist prevPoint) {
      this(p1,distance);
      this.prevPoint = prevPoint;
    }

  }

  @Getter
  @Setter
  @ToString
  private static class Point  {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
