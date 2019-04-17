package oop.design.library.management.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    3:17 PM
 */
@Getter
@Setter
@ToString
public class Address {

  private String city;
  private String state;
  private String pinCode;
  private String streetAddress;
  private String country;

}
