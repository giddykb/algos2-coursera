package machine.coding.MLPlatform.input.reader;

import machine.coding.MLPlatform.entity.Data;
import machine.coding.MLPlatform.entity.InputData;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:27 AM
 */
public class DbReader implements DataReader {
  @Override
  public Data read(InputData inputData) {
    System.out.println("Reading from DB, dataInfo :: " + inputData.toString());
    return new Data();
  }
}
