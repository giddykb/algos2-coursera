package oop.design.library.management.service;

import lombok.Getter;
import lombok.Setter;
import oop.design.library.management.enums.BookStatus;
import oop.design.library.management.model.Book;
import oop.design.library.management.model.Rack;

import java.util.Date;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    3:12 PM
 */
@Getter
@Setter
public class BookItem extends Book {

  private String barCode;
  private boolean isReferenceOnly;
  private Date borrowed;
  private Date dueDate;
  private double price;
  private Date dateOfPurchase;
  private Date publicationDate;
  private Rack rack;


  public boolean checkOut(String memberId) throws Exception {

    if(this.isReferenceOnly()) {
      throw new Exception("This book is reference only can't be issued");
    }

    if (!BookLending.lendBook(memberId,this.barCode)){
      return false;
    }

    this.updateBookItemStatus(BookStatus.LOANED);
    return true;
  }

  public void updateBookItemStatus(BookStatus bookStatus) {

  }
}
