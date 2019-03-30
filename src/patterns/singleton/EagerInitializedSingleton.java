package patterns.singleton;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/03/19
 * Time:    4:01 PM
 *
 * :::: Notes ::::
 *  singleton class is created at the time of class loading.
 *  drawback - instance is created even though the client application might not use it.
 *  This method doesn't provide any exception handling.
 */

public class EagerInitializedSingleton {

  private static EagerInitializedSingleton instance = new EagerInitializedSingleton();
  private EagerInitializedSingleton(){}

  public static EagerInitializedSingleton getInstance(){
    return instance;
  }

}
