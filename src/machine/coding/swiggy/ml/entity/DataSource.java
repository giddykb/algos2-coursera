package machine.coding.swiggy.ml.entity;

import lombok.Getter;
import lombok.Setter;
import machine.coding.swiggy.ml.enums.DataSourceType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:27 PM
 */
@Getter
@Setter
public abstract class DataSource {
  private int id;
  private String name;
  private DataSourceType sourceType;
  Data data;
}
