package machine.coding.swiggy.ml.writers;

import machine.coding.swiggy.ml.entity.ModelResult;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:27 PM
 */
public interface DataWriter {
  void write(ModelResult modelResult);
}
