package patterns.singleton;

import java.io.Serializable;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/03/19
 * Time:    5:03 PM
 *
 *
 */
public class SerializedSingleton implements Serializable {

  private SerializedSingleton() {}

  private static class SingletonHelper {
    private static final SerializedSingleton INSTANCE = new SerializedSingleton();
  }

  public SerializedSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }

  public Object readResolve() {
    return getInstance();
  }

}
