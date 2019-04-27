package machine.coding.swiggy.ml.service;

import lombok.Getter;
import lombok.Setter;
import machine.coding.swiggy.ml.entity.Data;
import machine.coding.swiggy.ml.entity.InputDataSource;
import machine.coding.swiggy.ml.entity.Model;
import machine.coding.swiggy.ml.entity.ModelResult;
import machine.coding.swiggy.ml.entity.ModelTaskInfo;
import machine.coding.swiggy.ml.entity.OutputDataSource;
import machine.coding.swiggy.ml.outputselectors.ModelOutputSelector;
import machine.coding.swiggy.ml.readers.DataReader;
import machine.coding.swiggy.ml.readers.DataReaderFactory;
import machine.coding.swiggy.ml.runners.ModelRunner;
import machine.coding.swiggy.ml.runners.ModelRunnerFactory;
import machine.coding.swiggy.ml.writers.DataWriter;
import machine.coding.swiggy.ml.writers.DataWriterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:06 PM
 */
@Getter
@Setter
public class ModelTaskExecutor {

  private List<Model> models = new ArrayList<>();
  private ModelOutputSelector outputSelector ;

  public ModelTaskExecutor(ModelOutputSelector outputSelector){
    outputSelector = this.outputSelector;
  }

  public void executeTask(ModelTaskInfo modelTaskInfo) {
    InputDataSource inputDataSource = modelTaskInfo.getInputDataSource();
    OutputDataSource outputDataSource = modelTaskInfo.getOutputDataSource();
    DataReader dataReader  = DataReaderFactory.getDataReader(inputDataSource);
    Data data =dataReader.read();

    List<ModelResult> results = new ArrayList<>();
    for (Model model : models) {
      ModelRunner modelRunner = ModelRunnerFactory.getModel(model);
      ModelResult result = modelRunner.execute(data);
      results.add(result);
    }
    ModelResult result = outputSelector.selectBestOutput(results);
    DataWriter dataWriter = DataWriterFactory.getDataWriter(outputDataSource);
    dataWriter.write(result);
  }

  public void addModel(Model newModel){
    models.add(newModel);
  }
}
