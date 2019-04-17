package oop.design.moviebooking.model;

import oop.design.moviebooking.enums.AccountStatus;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    31/03/19
 * Time:    10:27 PM
 */
public abstract  class Account {
  private String id;
  private String password;
  AccountStatus accountStatus;

  public abstract void resetPassword();

}
