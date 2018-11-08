package com.peace.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    19/07/18
 * Time:    3:37 PM
 */
public class BalancedParentheses {

  public  static  void main(String [] args) {
    int n = 2 ;
    System.out.println(generateParenthesis(n).toString());
  }

  public static List<String> generateParenthesis(int n) {
    List<String> results = new ArrayList<>();
    allValidParenthesis(n,n,results,"");
    return results;
  }

  private static void allValidParenthesis(int left, int right, List<String> results,String valid) {

    if ( left == 0 && right == 0 ) {
      results.add(valid);
      return;
    }
    if ( left > right) return;

    if( left > 0) {
      allValidParenthesis(left-1, right,results, valid + "(" );

    }
    if( right > 0) {
      allValidParenthesis(left, right-1,results, valid + ")" );
    }
  }

}
