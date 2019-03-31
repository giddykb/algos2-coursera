package oop.design;

import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    30/03/19
 * Time:    8:26 PM
 * https://thispointer.com/designing-a-configurable-logging-framework-using-observer-design-pattern/#comments
 */
public class Logger extends Subject {

  Map<MessageType,Boolean> messageStatusMap;
  Logger(){
    messageStatusMap.put(MessageType.ERROR, true);
    messageStatusMap.put(MessageType.WARNING, true);
    messageStatusMap.put(MessageType.INFO, true);
  }

  void writeLog( MessageType type , String message) {

    if(messageStatusMap.get(type)) {
      setData(message);
      notify(type);
    }

  }

  void enableLoggingOfMessage(MessageType type) {
    messageStatusMap.put(type, true);
  }

  void disableLoggingOfMessage(MessageType type) {
    messageStatusMap.put(type, false);
  }
}
