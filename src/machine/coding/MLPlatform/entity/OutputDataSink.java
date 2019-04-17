package machine.coding.MLPlatform.entity;

import lombok.Getter;
import lombok.Setter;
import machine.coding.MLPlatform.enums.DataSourceType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:18 AM
 */

@Setter
@Getter
public class OutputDataSink {

  private Integer id;
  private String name;
  private DataSourceType dataSourceType;

}
