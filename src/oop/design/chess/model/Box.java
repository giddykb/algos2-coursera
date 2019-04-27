package oop.design.chess.model;

import lombok.Getter;
import lombok.Setter;
import oop.design.chess.pieces.Piece;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    10:17 PM
 */

@Getter
@Setter
public class Box {
  private final int X;
  private final int Y;
  private Piece piece;

  public Box(int x, int y) {
    this.X = x;
    this.Y = y;
  }

  public Box(int x, int y, Piece piece) {
    this(x,y);
    this.piece = piece;
  }

}
