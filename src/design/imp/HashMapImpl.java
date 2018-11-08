package design.imp;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/09/18
 * Time:    8:15 AM
 */
public class HashMapImpl<K,V> {

  private static final int SIZE  = 16;
  private  Entry table[] = new Entry[SIZE];


  public Entry get(K key) {
    int hash = key.hashCode() %SIZE;
    Entry e = table[hash];
    while (e != null) {
      if (e.getKey().equals(key)) {
        return  e;
      }
      e = e.next;
    }

    return  null;
  }


  public void put(K key, V value) {
    int hash = key.hashCode() %SIZE;
    Entry e = table [hash] ;

    if ( e != null) {
      if (e.getKey().equals(key)) {
        e.value = value;
      } else {
        while ( e.next != null ) {
          e = e.next;
        }
        Entry entryInOldBucket = new Entry(key,value);
        e.next = entryInOldBucket;
      }
    }
    else {
      Entry entryInNewBucket = new Entry(key,value);
      table[hash] = entryInNewBucket;

    }

  }


  private static class Entry<K,V> {
    final K Key;
    V value;
    Entry next;

    Entry(K k, V value) {
      this.Key = k;
      this.value = value;
    }

    public K getKey() {
      return Key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }
  }


  public static void main(String[] args) {

    HashMap<String,String> map = new HashMap<>();
  }

}
