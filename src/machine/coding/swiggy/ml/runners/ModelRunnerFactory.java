package machine.coding.swiggy.ml.runners;

import machine.coding.swiggy.ml.entity.Model;
import machine.coding.swiggy.ml.enums.ModelType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:41 PM
 */
public class ModelRunnerFactory {

  public static ModelRunner getModel(Model model){
    ModelType type = model.getType();

    switch (type) {
      case ARIMA:
        return new ArimaModelRunner();
      case NN_REGRESSION:
        return new SvnModelRunner();
      case LINEAR_REGRESSION:
        return new LinearModelRunner();
    }
    return null;
  }
}
