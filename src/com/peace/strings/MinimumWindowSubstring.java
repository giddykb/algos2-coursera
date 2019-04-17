package com.peace.strings;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    14/04/19
 * Time:    4:45 PM
 *
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters
 * in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"

 */

public class MinimumWindowSubstring
{

  public static void main(String[] args) {

    String S = "ADOBECODEBANC";
    String T = "ABC";
    System.out.println(minWindow(S,T));
  }

  public static  String minWindow(String s, String t) {
    if ( s.length() == 0 || t.length() ==0)
      return "";

    HashMap<Character,Integer> dictionary = new HashMap<>();

    for (int i = 0; i < t.length() ; i++) {
      int count = dictionary.getOrDefault(t.charAt(i),0);
      dictionary.put(t.charAt(i),count+1);
    }

    HashMap<Character,Integer> window = new HashMap<>();

    int left = 0;
    int right = 0;

    int ans[] = {-1,0,0};

    int required = dictionary.size();
    int formed = 0;

    while (right < s.length()) {
      char c = s.charAt(right);
      window.put(c,window.getOrDefault(c,0) + 1);
      if (dictionary.containsKey(c ) &&
          window.get(c).intValue() == dictionary.get(c).intValue()) {
        formed++;
      }

      while (left <= right && required == formed) {

        if ( ans[0] == -1 || right - left  + 1 < ans[0] ) {
          ans[0] = right - left  + 1;
          ans[1] = left;
          ans[2] = right;
        }
        char l = s.charAt(left);
        window.put(l,window.get(l)-1);
        if(dictionary.containsKey(l) && window.get(l).intValue() < dictionary.get(l).intValue()) {
          formed--;
        }
        left++;
      }
      right++;
    }

    return ans[0] == -1? "" : s.substring(ans[1],ans[2]+1);
  }
}
