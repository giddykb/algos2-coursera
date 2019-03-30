package patterns.singleton;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/03/19
 * Time:    4:15 PM
 *
 *
 *
 *
 *              :: Notes :::
 *  similar to eager initialization. Here exception handling can be done.
 *
 *
 *
 *
 */
public class StaticBlockSingleton {

  private static  StaticBlockSingleton instance ;

  private StaticBlockSingleton(){}

  static {
    try{
      instance = new StaticBlockSingleton();
    } catch (Exception e) {
      throw  new RuntimeException("Exception occurred in creating singleton instance");
    }
  }

  public StaticBlockSingleton getInstance(){
    return instance;
  }
}
