package patterns.strategy;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/04/19
 * Time:    10:28 PM
 */
public class LoadBalancerStrategy<T> implements AssignmentStrategy {

  @Override
  public T assignTicket(Object data) {
    System.out.println("Assigning tickets based on load balancer");
    return null;
  }


}
