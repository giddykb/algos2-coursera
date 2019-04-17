package machine.coding.MLPlatform.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import machine.coding.MLPlatform.enums.DataSourceType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:11 AM
 */

@Getter
@Setter
@ToString
public class InputData {

  private Integer id;
  private String name;
  private DataSourceType sourceType;

}
