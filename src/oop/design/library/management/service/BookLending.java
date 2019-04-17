package oop.design.library.management.service;

import java.util.Date;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    8:41 PM
 */
public class BookLending {

  private Date creationDate;
  private Date dueDate;
  private Date returnDate;

  public static boolean lendBook(String memeberId, String barCode) {
    return false;
  }

  public static BookLending fetchLendingDetails(String barCode){
    return null;
  }

}
