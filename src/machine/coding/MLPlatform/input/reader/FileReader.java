package machine.coding.MLPlatform.input.reader;

import machine.coding.MLPlatform.entity.Data;
import machine.coding.MLPlatform.entity.InputData;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:24 AM
 */
public class FileReader implements DataReader {
  @Override
  public Data read(InputData inputData) {
    System.out.println("Reading data from  File, dataInfo : " +  inputData.toString());
    return new Data();
  }
}
