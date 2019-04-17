package machine.coding.splitwise.serivce;

import machine.coding.splitwise.entity.Group;
import machine.coding.splitwise.entity.User;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    11:27 PM
 */

public interface GroupService {

  Group addGroup(Group group);

  Group deleteGroup(int groupId);

  Group updateGroup(Group group);

  List<Group> getAllGroups();

  List<Group> getAllGroupsForUser(User user);

}
