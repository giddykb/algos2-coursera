package oop.design.chess.pieces;

import oop.design.chess.enums.PieceColor;
import oop.design.chess.game.Board;
import oop.design.chess.model.Box;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    10:57 PM
 */
public class Bishop extends Piece {

  public Bishop(PieceColor color){
    setPieceColor(color);
  }
  @Override
  public boolean canMove(Board board, Box start, Box end) {
    return false;
  }
}
