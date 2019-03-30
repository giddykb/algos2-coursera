package patterns.singleton;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/03/19
 * Time:    4:20 PM
 *
 *      NOTES
 *
 *
 * Creates the instance in global access method.
 * works fine in single threaded environment.
 * Issues occur in multi-threaded systems.
 * If multiple thread are in if condition at the same time multiple instances are created
 *
 */
public class LazyInitializedSingleton {

  private  static  LazyInitializedSingleton instance;
  private LazyInitializedSingleton(){}

  public static LazyInitializedSingleton getInstance(){
    if (instance == null) {
      instance = new  LazyInitializedSingleton();
    }
    return instance;
  }

}
