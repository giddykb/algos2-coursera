package uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    02/04/19
 * Time:    9:00 PM
 */
public class SmsSplitter {

  public static void main(String[] args) {
    String message = "Hi Sivasrinivas, your Uber is arriving now!";
    int limit = 25;
    splitMessage(message, limit);
  }

  public static void splitMessage(String message, int limit) {

    String suffix = "(x/y)";
    int chunkSize = limit - suffix.length();
    int idx = 0;
    List<String> result = new ArrayList<>();
    int endIdx = 0;

    while (idx < message.length() ) {
      endIdx = idx + chunkSize;
      if (endIdx > message.length() ) break;;
      while (message.charAt(endIdx) != ' ') {
        endIdx--;
      }

      result.add(message.substring(idx, endIdx));

      idx = endIdx + 1;
      while (message.charAt(idx) == ' ') {
        idx++;
      }

    }

    result.add(message.substring(idx));

    for (int i = 0; i < result.size() ; i++) {
      result.set(i, result.get(i) + "(" + (i+1) + "/" +result.size() + ")");
    }
    System.out.println(result.toString());
  }
}
