package machine.coding.MLPlatform.input.reader;

import machine.coding.MLPlatform.entity.Data;
import machine.coding.MLPlatform.entity.InputData;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:23 AM
 */
public interface DataReader {

  Data read(InputData inputData);

}
