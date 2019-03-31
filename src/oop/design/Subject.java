package oop.design;

import lombok.Getter;
import lombok.Setter;
import oop.design.MessageType;
import oop.design.Observer;

import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    30/03/19
 * Time:    8:11 PM
 */

@Getter
@Setter
public class Subject {

  private String data;
  private Map<Integer,List<Observer>> registryMap;

  void attach(MessageType type, Observer observer) {
    registryMap.get(type).add(observer);
  }

  void dettach(Observer observer) {
    for (Map.Entry<Integer,List<Observer>> entry : registryMap.entrySet()) {
      Integer event = entry.getKey();
      List<Observer> observerList = entry.getValue();
      observerList.remove(observer);
      registryMap.put(event, observerList);
    }
  }

  void notify(MessageType type) {
    List<Observer> observers = registryMap.get(type);
    for (Observer observer : observers) {
      observer.update(this);
    }

  }


}
