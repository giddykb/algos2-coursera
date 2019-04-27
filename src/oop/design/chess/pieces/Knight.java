package oop.design.chess.pieces;

import oop.design.chess.enums.PieceColor;
import oop.design.chess.game.Board;
import oop.design.chess.model.Box;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    10:42 PM
 */
public class Knight extends Piece {


  public Knight(PieceColor color){
    setPieceColor(color);
  }
  @Override
  public boolean canMove(Board board, Box start, Box end) {
    if(end.getPiece().getPieceColor() == this.getPieceColor()) {
      return false;
    }
    int x = Math.abs(start.getX() - end.getX());
    int y = Math.abs(start.getY() - end.getY());
    return x*y == 2;

  }
}
