package machine.coding.splitwise.entity;

import machine.coding.splitwise.enums.Currency;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    10:49 PM
 */
public class Contribution {

  private Integer userId;
  private float share;
  private Currency currency = Currency.INR;

  public Contribution(User user, float share) {
    this.userId = user.getId();
    this.share = share;

  }
}
