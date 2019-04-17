package machine.coding.splitwise.helper;

import machine.coding.splitwise.entity.Contribution;
import machine.coding.splitwise.entity.User;
import machine.coding.splitwise.enums.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    12:10 AM
 */
public class ContributionHelper {

  public static List<Contribution> splitEqually(List<User> users, int totalAmount,
                                                Currency billCurrency){
    List<Contribution> contributions = new ArrayList<>();
    int totalUsers = users.size();
    float share = totalAmount/ totalUsers;
    for (User user : users) {
      Contribution contribution = new Contribution(user, share);
      contributions.add(contribution);
    }

    return contributions;
  }

  public static List<Contribution> splitVariably(List<User> users, int totalAmount,
                                                 Currency currency, List<Float> shares) {
    List<Contribution> contributions = new ArrayList<>();

    return contributions;
  }
}
