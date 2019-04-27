package oop.design.chess.game;

import com.peace.dp.LIS;
import oop.design.chess.enums.GameStatus;
import oop.design.chess.pieces.King;
import oop.design.chess.pieces.Piece;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    11:50 PM
 */
public class Game {
  private Player [] players;
  private Board board;
  private Player currentTurn;
  private GameStatus status;
  private List<Move> movesPlayed;

  private  void initialize(Player p1, Player p2) {
    players[0] = p1;
    players[1] = p2;
    board.resetBoard();

    if (p1.isWhiteSide()){
      currentTurn = p1;
    } else {
      currentTurn = p2;
    }
    movesPlayed.clear();
  }

  public  boolean playerMove(Player player, Move move) {
    return this.makeMove(move, player);
  }

  private boolean makeMove(Move move, Player player){
    Piece sourcePiece = move.getStart().getPiece();
    if ( sourcePiece == null) return false;

    if (player != currentTurn) {
      return false;
    }

    if (sourcePiece.getPieceColor() != player.getColor()) return false;

    if(!sourcePiece.canMove(board,move.getStart(),move.getEnd())) {
      return false;
    }
    Piece destPiece = move.getEnd().getPiece();
    if( destPiece != null) {
      destPiece.setKilled(true);
      move.setPieceKilled(destPiece);
    }

    if(sourcePiece !=null && sourcePiece instanceof King
        && ((King) sourcePiece).isCastlingMove(move.getStart(),move.getEnd())){
      ((King) sourcePiece).setCastlingDone(true);
    }
    movesPlayed.add(move);
    move.getEnd().setPiece(move.getStart().getPiece());
    move.getStart().setPiece(null);


    return true;
  }
}
