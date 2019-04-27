package dcp;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    18/04/19
 * Time:    10:56 AM
 * https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
 */

public class MinimumStepsToTargetByKnight {

  public static void main(String[] args) {

    Cell KnightPosition = new Cell(4,5);
    Cell targetPosition = new Cell(1,1);
    int N = 8;
    int [][] chessBoard = new int[N][N];

    System.out.println(minSteps(KnightPosition,targetPosition,N));

  }

  public static int minSteps(Cell knightPosition, Cell targetPosition, int N ){

    int xDirection [] = {-2,2,-2,2,1,-1,1,-1};
    int yDirection [] = {-1,-1,1,1,-2,-2,2,2};
    int possibleMoves = xDirection.length;

    Queue<Cell> cellQueue = new LinkedList<>();
    cellQueue.add(knightPosition);
    HashMap<String,Boolean> isVisited = new HashMap<>();
    while (!cellQueue.isEmpty()) {
      Cell currNode = cellQueue.remove();

      if(currNode.x == targetPosition.x && currNode.y == targetPosition.y) {
        return currNode.getDistance();
      }

      for (int i = 0; i < possibleMoves ; i++) {
        int xPos = xDirection[i] + currNode.x;
        int yPos = yDirection[i] + currNode.y;

        if (isValidMove(xPos, yPos,N) && !isVisited.containsKey(xPos +"|" + yPos)) {
          isVisited.put(xPos +"|" + yPos,true);
          cellQueue.add(new Cell(xPos,yPos,currNode.getDistance() + 1));
        }
      }
    }
    return -1;
  }

  public static boolean isValidMove(int x, int y,int N) {

    if(x >=0 && x < N && y >=0 && y < N) {
      return true;
    }
    return false;

  }
  @Getter
  @Setter
  private static class Cell {
    int x;
    int y;
    int distance;

    Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }
    Cell(int x, int y, int distance) {
      this(x,y);
      this.distance = distance;
    }
  }
}
