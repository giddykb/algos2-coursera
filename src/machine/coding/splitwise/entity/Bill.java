package machine.coding.splitwise.entity;

import lombok.Getter;
import lombok.Setter;
import machine.coding.splitwise.enums.Currency;
import machine.coding.splitwise.enums.SplitType;

import java.io.Serializable;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    10:43 PM
 */

@Getter
@Setter
public class Bill implements Serializable {

  private Integer id;
  private Integer billNo;
  private String title;
  private String description;
  private Integer totalAmount;
  private Currency currency;
  private List<Contribution> paidContributions;
  private List<Contribution> payableContributions;
  private SplitType splitType;


}
