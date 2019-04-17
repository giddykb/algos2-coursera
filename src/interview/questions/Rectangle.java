package interview.questions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    9:08 PM
 */

@Getter
@Setter
public class Rectangle {

  Point topLeft;
  Point bottomRight;

  Rectangle(Point p1 , Point p2) {
    this.topLeft = p1;
    this.bottomRight = p2;
  }

  @Getter
  @Setter
   static  class  Point {
    int x;
    int y;

    Point(int x, int y){
      this.x = x;
      this.y = y;
    }

  }

  public static void main(String[] args) {
    Point p1 = new Point(10,20);
    Point p2 = new Point(5,30);
    Rectangle r1 = new Rectangle(p1,p2);


    Point p3 = new Point(10,20);
    Point p4 = new Point(5,30);
    Rectangle r2 = new Rectangle(p3,p4);

   boolean result = RectangleIntersect.doOverlap(r1,r2);

    System.out.println(result);

  }
}
