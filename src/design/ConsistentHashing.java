package design;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/09/18
 * Time:    4:48 PM
 */
public class ConsistentHashing <T>  implements  Cloneable{

  private int totalReplicas = 10;
  private TreeMap<Integer,T> circle = new TreeMap<>();

  MessageDigest md ;

  void initMd5() {
    try {
      md = MessageDigest.getInstance("MD%");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  ConsistentHashing() {
    initMd5();
  }

  ConsistentHashing(ConsistentHashing tClone) {
    this.totalReplicas = tClone.totalReplicas;
    this.circle = tClone.circle;
  }

   ConsistentHashing (int totalReplicas, Collection<T> node) {
    this.totalReplicas = totalReplicas;
  }

  public void add(T node) {
    for (int i = 0; i < totalReplicas ; i++) {
      String n = node.toString() + i ;
      circle.put(md.digest(n.getBytes()).hashCode(), node);

    }
  }

  public T get(Object o) {
    Map.Entry<Integer, T> entry ;
    int hash = md.digest(o.toString().getBytes()).hashCode();
    entry = circle.higherEntry(hash);
    if ( entry == null) {
      entry = circle.higherEntry(Integer.MIN_VALUE);
    }

    return  entry.getValue();
  }

}
