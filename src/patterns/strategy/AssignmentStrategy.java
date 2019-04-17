package patterns.strategy;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/04/19
 * Time:    10:26 PM
 */
public interface AssignmentStrategy<T,V> {
  T assignTicket( V data);
}
