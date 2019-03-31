package oop.design.impl;

import oop.design.Observer;
import oop.design.Subject;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    30/03/19
 * Time:    8:23 PM
 */
public class ConsoleLoggingPlatform implements Observer {

  @Override
  public void update(Subject subject) {
    System.out.println(subject.getData());
  }
}
