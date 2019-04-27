package machine.coding.swiggy.ml.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import machine.coding.swiggy.ml.enums.ModelType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:43 PM
 */

@Getter
@Setter
@Builder
public class Model {
  private int id;
  private String name;
  ModelType type;
  public Model(int id, String name, ModelType type){
    this.id = id;
    this.name = name;this.type = type;


  }
}
