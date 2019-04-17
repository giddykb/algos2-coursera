package machine.coding.splitwise.serivce;

import machine.coding.splitwise.entity.Group;
import machine.coding.splitwise.entity.User;

import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    12:45 AM
 */
public interface BalanceService {

  Float getOverallBalanceForUser(User user);

  Map<String,Float> getGroupWiseBalanceForUser(User user);

  Float getGroupBalanceForUser(User user, Group group);

  Map<String, Float> getBalanceForGroup(Group group);

}
