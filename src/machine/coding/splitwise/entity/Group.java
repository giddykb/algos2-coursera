package machine.coding.splitwise.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    9:53 PM
 */
@Getter
@Setter
public class Group {

  private int id;
  private int name;
  private List<User> users;

}
