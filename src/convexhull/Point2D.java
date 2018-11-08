package convexhull;

import java.util.Comparator;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/06/18
 * Time:    12:45 PM
 * @noinspection ALL
 */
public class Point2D  implements  Comparable<Point2D> {

/*
  public static final Comparable<Point2D> X_ORDER = ;
  public static final Comparable<Point2D> Y_ORDER = ;
  public static final Comparable<Point2D> P_ORDER = ;
*/

  private final double x;
  private final double y;

  Point2D(double x,double y){
    if(Double.isInfinite(x) || Double.isInfinite(y))
      throw new IllegalArgumentException("Coordinates must be finite");
    if (Double.isNaN(x) || Double.isNaN(y))
      throw  new IllegalArgumentException("Coordinates cannot be NAN");
    this.x =x;
    this.y =y;

  }

  public double x(){ return   x; }

  public  double y() { return y; }


  public double r() {
    return Math.sqrt(x*x + y*y);
  }

  public double theta(){
    return Math.atan2(y,x);
  }

  private  double angleTo(Point2D that) {
    double dx = that.x - this.x ;
    double dy = that.y - this.y ;
    return  Math.atan2(dy,dx);

  }

  public static  int ccw(Point2D a, Point2D b, Point2D c){
   double area = (b.x -a.x) * (c.x -a.x) - (b.y - a.y)*(c.y - a.y) ;
   if(area > 0 ) return 1;
   else if( area < 0) return -1;
   else return 0;

  }

  public double distanceTo(Point2D that){
    double dx = that.x - this.x;
    double dy = that.y - this.y;
    return  Math.sqrt(dx*dx +dy*dy);
  }

  public double distanceSquaredTo(Point2D that){
    double dx = that.x - this.x;
    double dy = that.y - this.y;
    return  dx*dx +dy*dy;
  }

  private  static  class  XOrder implements Comparator<Point2D> {

    @Override
    public int compare(Point2D p, Point2D q) {
      if(p.x < q.x) return -1;
      if(p.x > q.x) return +1;
      return 0;
    }
  }

  private  static  class  YOrder implements Comparator<Point2D> {

    @Override
    public int compare(Point2D p, Point2D q) {
      if(p.y < q.y) return -1;
      if(p.y > q.y) return +1;
      return 0;
    }
  }




  @Override
  public int compareTo(Point2D that) {
    if(this.y < that.y ) return -1;
    if(this.y > that.y)  return  1;
    if(this.x < that.x ) return -1;
    if(this.x > that.x ) return 1;
    return  0;
  }
}
