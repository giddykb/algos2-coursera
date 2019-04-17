package interview.questions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    9:03 PM
 */

@Getter
@Setter
public class RectangleIntersect {

  static boolean doOverlap(Rectangle r1, Rectangle r2) {
    // check if one of rectangle is left or right
    if (r2.getTopLeft().getX() > r1.getBottomRight().getX() ||
        r1.getTopLeft().getX() > r2.getBottomRight().getX()) {
      return false;
    }

    // check if any rectangle top or bottom
    if (r1.getBottomRight().getY() > r2.getTopLeft().getY() ||
        r2.getBottomRight().getY() > r1.getTopLeft().getY()) {
      return false;
    }
    return true;
  }

}
