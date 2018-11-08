package com.peace.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    20/09/18
 * Time:    6:43 AM
 */
public class LRUCache {

  private DoublyLinkedList pageList;
  private Map<Integer, Node> pageMap;
  private final int cacheSize;

  LRUCache(int capacity ) {
    this.cacheSize = capacity;
    pageList = new DoublyLinkedList(cacheSize);
    pageMap = new HashMap<>();

  }


  public void accessPage(int pageNo) {
    Node pageNode= null;
    if(pageMap.containsKey(pageNo)) {
      pageNode = pageMap.get(pageNo);
      pageList.movePageToHead(pageNode);
    }
    else {
      if (cacheSize == pageList.getCapacity()) {
        pageMap.remove(pageList.getTail().getPageNo());
        pageList.remove();
      }

      pageNode = pageList.addPage(pageNo);
      pageMap.put(pageNo, pageNode);

    }

  }

  public void printCacheState() {
    pageList.print();
    System.out.println();
  }


}
