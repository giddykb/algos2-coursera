package machine.coding.splitwise.serivce.impl;

import machine.coding.splitwise.entity.Group;
import machine.coding.splitwise.entity.User;
import machine.coding.splitwise.serivce.BalanceService;
import machine.coding.splitwise.serivce.BillService;

import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    12:58 AM
 */
public class BalanceServiceImpl implements BalanceService {

  BillService billService;

  @Override
  public Float getOverallBalanceForUser(User user) {
    return null;
  }

  @Override
  public Map<String, Float> getGroupWiseBalanceForUser(User user) {
    return null;
  }

  @Override
  public Float getGroupBalanceForUser(User user, Group group) {
    return null;
  }

  @Override
  public Map<String, Float> getBalanceForGroup(Group group) {
    return null;
  }
}
