package oop.design.chess.pieces;

import lombok.Getter;
import lombok.Setter;
import oop.design.chess.enums.PieceColor;
import oop.design.chess.game.Board;
import oop.design.chess.model.Box;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    10:47 PM
 */
@Getter
@Setter
public class King extends Piece {
  private boolean isCastlingDone;

  King(PieceColor color){
    setPieceColor(color);
  }

  @Override
  public boolean canMove(Board board, Box start, Box end) {
    if (end.getPiece().getPieceColor() == this.getPieceColor()) {
      return false;
    }
    int x = Math.abs(start.getY() - end.getX());
    int y = Math.abs(start.getY() - end.getY());

    if ( x+y ==1) return true;

    return isValidCastling(board,start,end);
  }

  private boolean isValidCastling(Board board, Box start, Box end) {
    if (isCastlingDone()) return false;

    return false;
  }

  public boolean isCastlingMove(Box start, Box end) {
    // check if the starting and ending position are correct
    return false;
  }
}
