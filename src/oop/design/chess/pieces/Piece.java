package oop.design.chess.pieces;

import lombok.Getter;
import lombok.Setter;
import oop.design.chess.enums.PieceType;
import oop.design.chess.enums.PieceColor;
import oop.design.chess.game.Board;
import oop.design.chess.model.Box;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    10:11 PM
 */
@Getter
@Setter
public abstract class Piece {

  private PieceType pieceType;
  private PieceColor pieceColor;
  private boolean isKilled;

  public  abstract boolean canMove(Board board, Box start, Box end);
}
