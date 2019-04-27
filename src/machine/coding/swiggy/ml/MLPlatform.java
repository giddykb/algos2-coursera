package machine.coding.swiggy.ml;

import machine.coding.swiggy.ml.entity.Model;
import machine.coding.swiggy.ml.entity.ModelTaskInfo;
import machine.coding.swiggy.ml.enums.ModelType;
import machine.coding.swiggy.ml.service.ModelTaskExecutor;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:38 PM
 */
public class MLPlatform {
  ModelTaskExecutor modelTaskExecutors;

  MLPlatform(){
    modelTaskExecutors.addModel(new Model(1, "ARIMA", ModelType.ARIMA));
    modelTaskExecutors.addModel(new Model(1, "SVN", ModelType.NN_REGRESSION));
    modelTaskExecutors.addModel(new Model(1, "Linear", ModelType.LINEAR_REGRESSION));
  }

  public void runModels(ModelTaskInfo modelTaskInfo) {
    modelTaskExecutors.executeTask(modelTaskInfo);
  }
}
