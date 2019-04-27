package priorityqueues;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    23/04/19
 * Time:    9:50 AM
 */
public class MedianFinder {

  PriorityQueue<Integer> minHeapUpperHalf ;
  PriorityQueue<Integer> maxHeapLowerHalf ;

  /** initialize your data structure here. */
  public MedianFinder() {
    minHeapUpperHalf = new PriorityQueue();
    maxHeapLowerHalf = new PriorityQueue(Collections.reverseOrder());
  }

  public void addNum(int num) {
    if(maxHeapLowerHalf.size () == 0 ||  num < maxHeapLowerHalf.peek() ) {
      maxHeapLowerHalf.offer(num);
    } else {
      minHeapUpperHalf.offer(num);
    }
    rebalance();
  }

  private void rebalance() {
    PriorityQueue<Integer> biggerHeap =
        minHeapUpperHalf.size() > maxHeapLowerHalf.size() ? minHeapUpperHalf :  maxHeapLowerHalf;
    PriorityQueue<Integer> smallerHeap =
        minHeapUpperHalf.size() > maxHeapLowerHalf.size() ? maxHeapLowerHalf :  minHeapUpperHalf;
    if (biggerHeap.size() - smallerHeap.size() >= 2) {
      smallerHeap.offer(biggerHeap.poll());
    }
  }

  public double findMedian() {
    PriorityQueue<Integer> biggerHeap =
        minHeapUpperHalf.size() > maxHeapLowerHalf.size() ? minHeapUpperHalf :  maxHeapLowerHalf;
    PriorityQueue<Integer> smallerHeap =
        maxHeapLowerHalf.size() > minHeapUpperHalf.size() ? maxHeapLowerHalf :  minHeapUpperHalf;

    if (biggerHeap.size() == smallerHeap.size()) {
      return (double) (biggerHeap.peek() + smallerHeap.peek())/2 ;
    }
    else return biggerHeap.peek();
  }

  public  class MaxComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return 0;
    }
  }
  public static void main(String[] args) {
    int a [] = new int []{1,2,3} ;
    double medians [] = new double[a.length];
    MedianFinder mf = new MedianFinder();
    for (int i = 0; i < a.length; i++) {
      mf.addNum(a[i]);
      medians[i] = mf.findMedian();
    }
    System.out.println(Arrays.toString(medians));
  }
}
