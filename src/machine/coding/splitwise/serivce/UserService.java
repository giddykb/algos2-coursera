package machine.coding.splitwise.serivce;

import machine.coding.splitwise.entity.User;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    11:22 PM
 */
public interface UserService {

  User addUser(User user);
  void deleteUser(User user);
  User getUser(int userId);
  List<User> getAllUsers();
}
