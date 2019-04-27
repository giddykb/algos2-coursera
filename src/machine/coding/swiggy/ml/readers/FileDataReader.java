package machine.coding.swiggy.ml.readers;

import machine.coding.swiggy.ml.entity.Data;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    5:57 PM
 */
public class FileDataReader implements DataReader {
  @Override
  public Data read() {
    Data data = new Data();
    data.setData("Reading from file");
    return data;
  }
}
