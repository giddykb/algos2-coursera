package amazon;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    23/04/19
 * Time:    8:19 PM
 */
public class KClosestPoints {


  public static void main(String[] args) {
   // int[][] points = {{3,3},{5,-1},{-2,4}};
    int[][] points = {{1,3},{-2,2}};
    int K = 1;
    int[][] result = kClosestSolution(points,K);
    //System.out.println(Arrays.toString(result));
  }

  public static  int[][] kClosestSolution(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
        (p1,p2) -> p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] -p1[1]*p1[1]);
    for (int [] p: points) {
      pq.offer(p);
      if(pq.size() > K) {
        pq.poll();
      }
    }
    int res[][] = new int[K][2];
    while (K > 0) {
      res[--K] = pq.poll();
      System.out.println(res[K][0] + "," + res[K][1]);
    }

    return res;
  }

    public static int[][] kClosest(int[][] points, int K) {

      PriorityQueue<Point> closesPoints = new PriorityQueue(K,
                                                            new ClosestPointsComparator().reversed());
      Point p = null;
      for(int i=0; i< points.length; i++) {
        int x = points[i][0];
        int y = points[i][1];
        p = new Point(x,y);
        closesPoints.offer(p);
        while (closesPoints.size()> K) {
          closesPoints.poll();

        }
      }

      int[][] result = new int[K][2];
      Point points1 [] = new Point[K];
      closesPoints.toArray(points1);

      for (int i=0; i< K; i++) {
        result[i][0] = points1[i].x;
        result[i][1] =  points1[i].y;
        System.out.println(result[i][0] + ", " + result [i][1]);
      }
      return result;
    }

    private static class ClosestPointsComparator implements Comparator<Point> {
      @Override
      public int compare(Point a, Point b) {
        double p1Distance = Math.pow(a.x,2) + Math.pow(a.y,2);
        double p2Distance = Math.pow(b.x,2) + Math.pow(b.y,2);

        if (p1Distance < p2Distance) return -1;
        else if (p1Distance > p2Distance) return 1;
        else return 0;

      }
    }

    private static class Point {
      int x;
      int y;

      Point(int x, int y) {
        this.x = x ;
        this.y = y ;
      }
    }
}
