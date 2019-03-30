package patterns.singleton;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/03/19
 * Time:    4:39 PM
 *
 *
 *
 *
 *
 *  singleton is created using static inner helper class.
 *  private inner static class contains the singleton class.
 *  When singleton class is loaded  SingletonHelper class is not loaded into memory.
 *  It is loaded only when someone calls the getInstance() method.
 *
 *
 *
 */
public class BillPughSingleton {


  private BillPughSingleton(){}

  private static class SingletonHelper {
    private static final BillPughSingleton INSTANCE =  new BillPughSingleton();
  }

  public static BillPughSingleton getInstance(){
    return SingletonHelper.INSTANCE;
  }

}
