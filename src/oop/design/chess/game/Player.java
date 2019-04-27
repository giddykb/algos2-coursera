package oop.design.chess.game;

import lombok.Getter;
import lombok.Setter;
import oop.design.chess.enums.PieceColor;
import oop.design.chess.model.Person;


/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/04/19
 * Time:    11:12 PM
 */
@Getter
@Setter
public class Player {
  private Person person;
  private boolean isWhiteSide;
  private PieceColor color;

  public Player( Person person, boolean isWhiteSide){
    this.person = person;
    this.isWhiteSide = isWhiteSide;
  }
}
