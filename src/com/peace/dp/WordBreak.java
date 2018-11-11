package com.peace.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/11/18
 * Time:    12:21 AM
 */
public class WordBreak {

  public static void main(String[] args) {

    List<String> dict = new ArrayList<>();
    dict.add("I"); dict.add("have"); dict.add("Jain");
    dict.add("Sumit"); dict.add("am"); dict.add("this"); dict.add("dog");
    //dict.add("");
    String input= "thisisadog";
    System.out.println(segmentString(input, dict));

  }

  private static String segmentString(String input, List<String> dict) {
    if( dict.contains(input)) return input;
    for (int i = 1; i < input.length(); i++) {
      String prefix = input.substring(0,i);

      if (dict.contains(prefix)) {
        String suffix = segmentString(input.substring(i),dict);
        if (suffix != null) {
          return  prefix +" " + suffix;
        }
      }

    }

    return null;
  }

  private static  String segmentStringOptimized(String input, List<String> dict,
                                                Map<String,String> cached) {
    if( dict.contains(input)) return input;
    if( cached.containsKey(input)) {
      return cached.get(input);
    }

    for (int i =1 ; i < input.length(); i++) {
      String prefix = input.substring(0,i);
      if ( dict.contains(prefix)) {
        String suffix = segmentStringOptimized(input.substring(i),dict,cached);
        if ( cached != null) {
          cached.put(input, prefix +" " + suffix);
          return prefix +" " + suffix;
        }

      }
    }
    cached.put(input, null);
    return null;
  }


  private static boolean worBreak(String input, List<String> dict) {
    boolean isWordBreak[] = new boolean[input.length() + 1];
    isWordBreak[0] = true;

    for (int i = 0; i < isWordBreak.length; i++) {
      for (int j = 0; j < i; j++) {
        if (!isWordBreak[j]) {
          continue;
        }

        if( dict.contains(input.substring(j,i))) {
          isWordBreak[i] = true;
          break;
        }

      }
    }

    return isWordBreak[input.length()];

  }


}
