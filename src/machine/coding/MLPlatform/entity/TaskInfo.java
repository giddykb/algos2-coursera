package machine.coding.MLPlatform.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:14 AM
 */
@Getter
@Setter
public class TaskInfo {

  private Integer id;
  private String name;
  private InputData inputData;
  private OutputDataSink outputDataSink;


}
