package machine.coding.threadpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    15/04/19
 * Time:    8:43 AM
 */
public class BlockingQueue<Type> {

  private Queue<Type> queue = new LinkedList<>();
  private int MAX_TASKS_IN_QUEUE = 1;


  BlockingQueue(int size) {
    this.MAX_TASKS_IN_QUEUE = size;
  }


  public synchronized void enqueue(Type task) throws InterruptedException {

    while (queue.size() == MAX_TASKS_IN_QUEUE) {
      wait();
    }
    if(this.queue.isEmpty()) {
      notifyAll();
    }
    this.queue.offer(task);
  }

  public synchronized Type dequeue() throws InterruptedException {

    while (queue.isEmpty()) {
      wait();
    }

    if (queue.size() == MAX_TASKS_IN_QUEUE) {
      notifyAll();
    }

    return  this.queue.poll();
  }
}
