package machine.coding.swiggy.ml.readers;

import machine.coding.swiggy.ml.entity.DataSource;
import machine.coding.swiggy.ml.enums.DataSourceType;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:00 PM
 */
public class DataReaderFactory {

  public static DataReader getDataReader(DataSource dataSource) {
    DataSourceType dataSourceType = dataSource.getSourceType();
    switch (dataSourceType) {
      case FILE:
        return new FileDataReader();
      case DB:
        return new DBDataReader();
    }
    return null;
  }
}
