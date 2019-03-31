package oop.design.impl;

import oop.design.Observer;
import oop.design.Subject;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    30/03/19
 * Time:    8:24 PM
 */
public class FlatFileloggingPlatform implements Observer {
  String fileName ;

  FlatFileloggingPlatform(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void update(Subject subject) {
    //To-Do  write data to file
  }
}
