package machine.coding.splitwise.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    9:53 PM
 */

@Getter
@Setter
public class User implements Serializable{

  private int id;
  private String name;
  private String email;

}
