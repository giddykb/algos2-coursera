package com.peace.strings;

import java.util.ArrayList;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/07/18
 * Time:    8:18 PM
 */
public class Permutate {
  public  static  void main(String [] args) {
    String s = "abc";
    ArrayList<String> results =  permutate(s);
    System.out.println(results.toString());

  }

  private  static ArrayList<String> permutate(String s){
    ArrayList<String> results = new ArrayList<>();
    permutate("",s,results);
    return  results;
  }

  private  static  void permutate(String prefix, String suffix,ArrayList<String> results) {
    if (suffix.length() == 0) {
      results.add(prefix);
    } else {
      for (int i = 0; i < suffix.length() ; i++) {
        String p  = prefix + suffix.charAt(i);
        String s =  suffix.substring(0,i) + suffix.substring(i+1,suffix.length());
        permutate(p,s,results);

      }
    }

  }
}
