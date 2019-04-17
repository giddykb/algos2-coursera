package oop.design.library.management.service;

import lombok.Getter;
import lombok.Setter;
import oop.design.library.management.constants.Constant;
import oop.design.library.management.model.Account;

import java.util.Date;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    3:35 PM
 */

@Getter
@Setter
public class Member extends Account {
  private Date dateOfMemberShip;
  private  int totalCheckedOutBooks;

  public boolean checkOutBookItem( BookItem bookItem) {
    if(this.getTotalCheckedOutBooks() >= Constant.MAX_BOOKS_ISSUED_PER_USER) {
      System.out.println("");
    }
    return false;
  }
}
