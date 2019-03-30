package patterns.singleton;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/03/19
 * Time:    4:26 PM
 */
public class ThreadSafeSingleton {
  private static  ThreadSafeSingleton instance;

  private ThreadSafeSingleton() {}

  public static synchronized ThreadSafeSingleton getInstance() {
    if (instance == null) {
      instance = new ThreadSafeSingleton();
    }
    return instance;
  }

  public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
    if (instance == null) {
      synchronized (ThreadSafeSingleton.class){
        if (instance == null) {
          instance = new ThreadSafeSingleton();
        }
      }
    }
    return instance;
  }
}
