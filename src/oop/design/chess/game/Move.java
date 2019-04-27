package oop.design.chess.game;

import lombok.Getter;
import lombok.Setter;
import oop.design.chess.model.Box;
import oop.design.chess.pieces.Piece;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    11:21 PM
 */

@Getter
@Setter
public class Move {
  private  Player player;
  private Box start;
  private Box end;
  private Piece pieceMoved;
  private Piece pieceKilled;
  private boolean isCastlingMove;

  Move(Player player, Box start, Box end) {
    this.player = player;
    this.start = start;
    this.end = end;
    this.pieceMoved = start.getPiece();
  }


}
