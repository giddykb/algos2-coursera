package machine.coding.threadpool;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    15/04/19
 * Time:    8:58 AM
 */
public class ThreadPool {
  BlockingQueue<Runnable> queue ;


  ThreadPool(int queueSize, int totalThreads) {

    queue = new BlockingQueue(queueSize);
    String threadName = null;
    TaskExecutor taskExecutor = null;
    for (int i = 0; i < totalThreads; i++) {
      threadName = "Thread ## " +i;
      taskExecutor = new TaskExecutor(queue);
      Thread thread = new Thread(taskExecutor, threadName);
      thread.start();
    }
    
  }

  public void submitTask(Runnable task) throws InterruptedException {
    this.queue.enqueue(task);

  }
}
