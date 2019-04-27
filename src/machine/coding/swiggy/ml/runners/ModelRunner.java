package machine.coding.swiggy.ml.runners;

import machine.coding.swiggy.ml.entity.Data;
import machine.coding.swiggy.ml.entity.ModelResult;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:32 PM
 */
public interface ModelRunner {
  ModelResult execute(Data data);
}
