package machine.coding.threadpool;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    15/04/19
 * Time:    8:58 AM
 */
public class TaskExecutor implements  Runnable {

  BlockingQueue<Runnable> queue;


  TaskExecutor(BlockingQueue<Runnable> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {

    while (true) {
      try {
        String name = Thread.currentThread().getName();
        Runnable task = queue.dequeue();
        System.out.println("Task started by thread ::: " + name);
        task.run();
        System.out.println("Task completed by thread ::: " + name);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
