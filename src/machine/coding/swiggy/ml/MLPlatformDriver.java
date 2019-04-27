package machine.coding.swiggy.ml;

import machine.coding.swiggy.ml.entity.InputDataSource;
import machine.coding.swiggy.ml.entity.ModelTaskInfo;
import machine.coding.swiggy.ml.entity.OutputDataSource;
import machine.coding.swiggy.ml.outputselectors.AccuracyOutputSelector;
import machine.coding.swiggy.ml.outputselectors.ModelOutputSelector;
import machine.coding.swiggy.ml.service.ModelTaskExecutor;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:42 PM
 */
public class MLPlatformDriver {
  public static void main(String[] args) {
    ModelOutputSelector outputSelector = new AccuracyOutputSelector();
    ModelTaskExecutor modelTaskExecutor = new ModelTaskExecutor(outputSelector);
    MLPlatform platform = new MLPlatform();
    ModelTaskInfo taskInfo = new ModelTaskInfo();
    taskInfo.setInputDataSource(new InputDataSource());
    taskInfo.setOutputDataSource(new OutputDataSource());
    taskInfo.setId(1);
    taskInfo.setName("task-1");
    platform.runModels(taskInfo);
  }
}
