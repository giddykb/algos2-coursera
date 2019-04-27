package machine.coding.swiggy.ml.runners;

import machine.coding.swiggy.ml.entity.Data;
import machine.coding.swiggy.ml.entity.ModelOutput;
import machine.coding.swiggy.ml.entity.ModelResult;
import machine.coding.swiggy.ml.enums.ModelType;

import java.util.Random;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:40 PM
 */
public class SvnModelRunner implements ModelRunner {

  @Override
  public ModelResult execute(Data data) {
    ModelResult result = new ModelResult();
    int accuracy  = new Random().nextInt(100);
    result.setAccuracy(accuracy);
    result.setModelType(ModelType.NN_REGRESSION);
    ModelOutput output = new ModelOutput() ;
    output.setResult("Result");
    result.setOutput(output);
    return result;

  }
}
