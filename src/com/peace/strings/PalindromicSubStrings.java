package com.peace.strings;

import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/03/19
 * Time:    2:12 PM
 */
public class PalindromicSubStrings {
  public static void main(String[] args) {
    String input = "aabac";
    Set<String>  allSubStrings = SubstringsOfString.subStringofString(input);
    for (String str: allSubStrings) {
      if(checkIfPalindrome(str)) {
        System.out.println(str);
      }
    }
  }

  public static boolean checkIfPalindrome(String str ) {
    if ( str.length() == 1) return true;
    char[] chars = str.toCharArray();
    int i = 0, j = chars.length - 1;

    while (i < j) {
      if (chars[i++] != chars[j--]){
        return false;
      }
    }

    return true;

  }
}
