package com.peace.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/03/19
 * Time:    1:03 PM
 */
public class SubstringsOfString {

  public static void main(String[] args) {
    String str = "abc";
    System.out.println(Arrays.asList(subStringofString(str)));

  }
  public static  Set<String> subStringofString(String str) {
    Set<String> result = new HashSet<>();
    for (int i =0 ; i< str.length(); i++) {
      for (int j = i+1 ; j<=str.length(); j++) {
        result.add(str.substring(i,j));
      }
    }
    return result;
  }
}
