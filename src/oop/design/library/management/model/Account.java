package oop.design.library.management.model;

import lombok.Getter;
import lombok.Setter;
import oop.design.library.management.enums.AccountStatus;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    3:27 PM
 */

@Getter
@Setter
public class Account extends  Person {

  private String id;
  private String password;
  private  AccountStatus accountStatus;
  private Person person;

  private boolean resetPassword(){
    return false;
  };
}
