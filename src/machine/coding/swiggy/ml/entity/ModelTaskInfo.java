package machine.coding.swiggy.ml.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:30 PM
 */

@Getter
@Setter
public class ModelTaskInfo {

  private int id;
  private String name;
  private InputDataSource inputDataSource;
  private OutputDataSource outputDataSource;
  
}
