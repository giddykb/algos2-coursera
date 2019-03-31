package oop.design.logging;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    30/03/19
 * Time:    8:24 PM
 */

public class NetworkLoggingPlatform implements Observer {
  @Override
  public void update(Subject subject) {
    String data  = subject.getData();
    // send data to network

  }
}
