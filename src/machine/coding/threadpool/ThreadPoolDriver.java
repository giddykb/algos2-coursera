package machine.coding.threadpool;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    15/04/19
 * Time:    9:18 AM
 */
public class ThreadPoolDriver {

  public static void main(String[] args) throws InterruptedException {

    int queueSize = 3;
    int totalThread  = 4 ;
    ThreadPool threadPool = new ThreadPool(queueSize, totalThread);
    for (int task = 0; task <=7 ; task++) {
      threadPool.submitTask(new Task<>(task));
    }
  }
}
