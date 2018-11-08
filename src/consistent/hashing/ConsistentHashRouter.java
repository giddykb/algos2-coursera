package consistent.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/10/18
 * Time:    12:12 AM
 */
public class ConsistentHashRouter<T extends Node> {

  private final SortedMap<Long,VirtualNode<T>> ring = new TreeMap<>();
  private final HashFunction hashFunction ;


  public  ConsistentHashRouter(Collection<T> pNodes, int vNodeCount) {
    this(pNodes,vNodeCount,new Md5Hash());
  }

  public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount, HashFunction hashFunction) {

    if (hashFunction == null) {
      throw new NullPointerException("Hash function cannot be null");
    }

    this.hashFunction = hashFunction;

    for (T node: pNodes) {
      addNode(node,vNodeCount);
    }

  }

  public void addNode(T node, int vCount){

    if(vCount < 0) throw new IllegalArgumentException("illegal virtual node count: " + vCount);
    int existingReplicas = getExistingReplicas(node);
    for (int i=0; i< vCount; i++) {
      VirtualNode<T> vNode = new VirtualNode<>(node, i+existingReplicas);
      ring.put(hashFunction.hash(node.getKey()),vNode);
    }

  }

  public void removeNode(T pNode) {
    Iterator<Long> iterator = ring.keySet().iterator();
    while (iterator.hasNext()) {
      Long key = iterator.next();
      VirtualNode<T> vNode = ring.get(key);
      if(vNode.isVirtualNodeOf(pNode)) {
        iterator.remove();
      }

    }
  }

  public T routeNode(String key) {
    if ( ring.isEmpty()) {
      return  null;
    }
    Long hashVal = hashFunction.hash(key);
    SortedMap<Long, VirtualNode<T>> tailMap = ring.tailMap(hashVal);
    Long nodeHashVal = !tailMap.isEmpty() ?tailMap.firstKey():ring.firstKey();
    return ring.get(nodeHashVal).getPhysicalNode();
  }


  public int getExistingReplicas(T pNode) {
    int replicas = 0;
    for (VirtualNode node: ring.values()) {
      if(node.isVirtualNodeOf(pNode)){
        replicas++;
      }
    }
    return replicas;
  }


  private static class Md5Hash implements HashFunction {

    MessageDigest messageDigest ;

    public Md5Hash(){
      try {
        messageDigest = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
    }

    @Override
    public long hash(String key) {
      messageDigest.reset();
      messageDigest.digest(key.getBytes());
      byte [] digest = messageDigest.digest();

      long h = 0;
      for (int i = 0; i < 4; i++) {
        h <<= 8;
        h |= ((int) digest[i]) & 0xFF;
      }

      return h;
    }
  }

}
