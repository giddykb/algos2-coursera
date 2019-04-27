package machine.coding.swiggy.ml.writers;

import machine.coding.swiggy.ml.entity.OutputDataSource;
import machine.coding.swiggy.ml.enums.DataSourceType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:29 PM
 */
public class DataWriterFactory {

  public static DataWriter getDataWriter(OutputDataSource outputDataSource) {
    DataSourceType dataSourceType = outputDataSource.getSourceType();
    switch (dataSourceType) {
      case DB:
        return new DbDataWriter();
      case FILE:
        return new FileDataWriter();

    }
   return null;
  }
}
