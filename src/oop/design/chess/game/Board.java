package oop.design.chess.game;

import lombok.Getter;
import lombok.Setter;
import oop.design.chess.enums.PieceColor;
import oop.design.chess.model.Box;
import oop.design.chess.pieces.Bishop;
import oop.design.chess.pieces.Knight;
import oop.design.chess.pieces.Pawn;
import oop.design.chess.pieces.Piece;
import oop.design.chess.pieces.Rook;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    10:18 PM
 */
@Getter
@Setter
public class Board {

  Box[][] boxes;
  List<Piece> pieces;

  Board(){
    this.resetBoard();
  }

  public  void resetBoard(){
    //Initialize white pieces
    boxes[0][0] = new Box(0, 0, new Rook(PieceColor.WHITE));
    boxes[0][1] = new Box(0, 1, new Knight(PieceColor.WHITE));
    boxes[0][2] = new Box(0, 2, new Bishop(PieceColor.WHITE));

    for (int i = 0; i < 8 ; i++) {
      boxes[1][i] = new Box(1,i,new Pawn(PieceColor.WHITE));
    }

    // Initialize black pieces

    boxes[7][0] = new Box(0, 0, new Rook(PieceColor.WHITE));
    boxes[7][1] = new Box(0, 1, new Knight(PieceColor.WHITE));
    boxes[7][2] = new Box(0, 2, new Bishop(PieceColor.WHITE));

    for (int i = 0; i < 8 ; i++) {
      boxes[6][i] = new Box(1,i,new Pawn(PieceColor.WHITE));
    }
    for (int i = 1; i < 6 ; i++) {
      for (int j = 0; j < 8 ; j++) {
        boxes[i][j] = new Box(i,j,null);
      }
    }
  }
}
