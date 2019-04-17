package patterns.strategy;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/04/19
 * Time:    10:34 PM
 */
public class AssignemntClient {
  public static void main(String[] args) {
    TicketAssingment ticketAssingment = new TicketAssingment();
    ticketAssingment.setAssignmentStrategy(new LoadBalancerStrategy());
    Object data = "assignment creation";
    ticketAssingment.setData(data);
    System.out.println();
  }
}
