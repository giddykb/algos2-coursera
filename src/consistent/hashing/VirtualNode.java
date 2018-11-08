package consistent.hashing;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/10/18
 * Time:    12:05 AM
 */
public class VirtualNode<T extends Node> implements Node {

  final T physicalNode;
  final int replicaIdex ;

  public VirtualNode(T physicalNode, int replicaIdex){
    this.physicalNode = physicalNode;
    this.replicaIdex = replicaIdex;
  }

  public  T getPhysicalNode(){
    return physicalNode;
  }

  public boolean isVirtualNodeOf(T pNode) {
    return physicalNode.getKey().equals(pNode.getKey());
  }
  @Override
  public String getKey() {
    return physicalNode.getKey()+ "_"+replicaIdex;
  }
}
