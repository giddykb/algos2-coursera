package machine.coding.swiggy.ml.entity;

import lombok.Getter;
import lombok.Setter;
import machine.coding.swiggy.ml.enums.ModelType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:34 PM
 */
@Getter
@Setter
public class ModelResult {
  private ModelType modelType;
  private Integer accuracy;
  private ModelOutput output;
}
