package consistent.hashing;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/10/18
 * Time:    1:33 AM
 */
public class MyServiceNode implements Node {

  private final String idc;
  private final String port;
  private final String ipAddress;

  MyServiceNode(String idc,String ipAddress,String port) {
    this.idc =idc;
    this.port = port;
    this.ipAddress = ipAddress;

  }


  @Override
  public String getKey() {
    return idc+"_" +ipAddress + ":"+port;
  }

  public String toString(){
    return getKey();
  }

  public static void main(String[] args) {

    MyServiceNode m1 = new MyServiceNode("IDC1","127.0.0.1","8080");
    MyServiceNode m2 = new MyServiceNode("IDC2","127.0.0.1","8081");
    MyServiceNode m3 = new MyServiceNode("IDC3","127.0.0.1","8082");
    MyServiceNode m4 = new MyServiceNode("IDC4","127.0.0.1","8083");

    ConsistentHashRouter<MyServiceNode> consistentHashRouter = new ConsistentHashRouter
        <MyServiceNode>(Arrays.asList(m1,m2,m3,m4),5);

    String requestIP1 = "192.168.0.1";
    String requestIP2 = "192.168.0.2";
    String requestIP3 = "192.168.0.3";
    String requestIP4 = "192.168.0.4";
    String requestIP5 = "192.168.0.5";

    goRoute(consistentHashRouter,requestIP1,requestIP2,requestIP3,requestIP4,requestIP5);

  }

  private static void goRoute(ConsistentHashRouter<MyServiceNode> consistentHashRouter, String ... requestIps) {

    for (String requestIp : requestIps) {
      System.out.println(requestIp + " is route to " +consistentHashRouter.routeNode(requestIp));
    }

  }
}
