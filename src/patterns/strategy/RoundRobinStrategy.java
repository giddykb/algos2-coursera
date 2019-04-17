package patterns.strategy;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/04/19
 * Time:    10:27 PM
 */
public class RoundRobinStrategy<T> implements AssignmentStrategy {

  @Override
  public T assignTicket(Object data) {
    System.out.println("Assinging ticket based on round robin policy");
    return null;
  }

}
