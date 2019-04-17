package oop.design.library.management.service;

import lombok.Getter;
import lombok.Setter;
import oop.design.library.management.enums.ReservationStatus;

import java.util.Date;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    8:34 PM
 */
@Getter
@Setter
public class BookReservation {
  private Date creationDate;
  private String bookItemBarCode;
  private ReservationStatus reservationStatus;
  private String memberId;

  public static BookReservation fetchReservationDetails(String barCode) {
    return null;
  }
}
