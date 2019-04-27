package oop.design.moviebooking.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    31/03/19
 * Time:    10:27 PM
 */

@Getter
@Setter
public abstract class Person extends Account {
  private String name;
  private String email;
  private String phone;
  private String address;
}
