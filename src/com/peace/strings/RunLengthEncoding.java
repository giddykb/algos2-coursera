package com.peace.strings;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    23/04/19
 * Time:    8:27 AM
 */
public class RunLengthEncoding {

  public static void main(String[] args) {
    String input = "AAAABBBCCDAA";
    System.out.println(encode(input));
  }

  public static String encode(String input ) {
    if (input == null || input.length() == 0) return null;
    if (input.length() == 1) {
      return 1+input;
    }

    int index = 0;
    String result = "";
    int count = 1;
    while (index < input.length()) {
      while (index < input.length()-1 && input.charAt(index) == input.charAt(index+1)) {
        count++;
        index++;
      }
      result = result + count +  input.charAt(index);
      count =1;
      index++;
    }
    return result;
  }
  public static String decode(String input) {
    String res = "";
    return res;
  }
}
