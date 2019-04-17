package machine.coding.threadpool;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    15/04/19
 * Time:    8:39 AM
 */
public class Task<T> implements Runnable {

  private  T task;

  Task(T task) {
    this.task = task;
  }


  @Override
  public void run() {
    System.out.println("start executing the task ::: " + task);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("End executing the task ::: " + task);
  }
}
