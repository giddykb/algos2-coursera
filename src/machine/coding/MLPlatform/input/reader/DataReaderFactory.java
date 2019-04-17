package machine.coding.MLPlatform.input.reader;

import machine.coding.MLPlatform.entity.InputData;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:28 AM
 */
public class DataReaderFactory {

  public DataReader getDataReader(InputData inputData){

    switch (inputData.getSourceType()) {
      case DB:
        return new DbReader();
      case FILE:
        return new FileReader();
      default:
        return null;
    }

  }
}
