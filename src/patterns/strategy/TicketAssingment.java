package patterns.strategy;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/04/19
 * Time:    10:28 PM
 */
public class TicketAssingment<T> {
  private AssignmentStrategy assignmentStrategy;

  public void setAssignmentStrategy(AssignmentStrategy assignmentStrategy) {
    this.assignmentStrategy = assignmentStrategy;
  }

  public Object setData(Object data){
    return assignmentStrategy.assignTicket(data);
  }
}
