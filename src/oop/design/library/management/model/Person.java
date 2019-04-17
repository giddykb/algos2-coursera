package oop.design.library.management.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    3:26 PM
 */
@Getter
@Setter
public class Person {
  private String name;
  private String email;
  private Address address;
  private String phone;
}
