package com.peace.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/11/18
 * Time:    9:58 AM
 */
public class ReverseString {

  public static void main(String[] args) {

    String str = "AB$C%D_EF";
    int i = 0;
    int j = str.length()-1;

    while( i < j) {
      char c = str.charAt(i);
      char t = str.charAt(j);
    }
  }


  public boolean  getSpecialCharacter(String s) {
    if (s == null || s.trim().isEmpty()) {
      System.out.println("Incorrect format of string");
      return false;
    }

    Pattern p = Pattern.compile("[^A-Za-z0-9]");
    Matcher m = p.matcher(s);
    // boolean b = m.matches();
    boolean b = m.find();
    if (b == true)
      System.out.println("There is a special character in my string ");
    else
      System.out.println("There is no special char.");
    return b;

  }
}
