package com.peace.strings;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/03/19
 * Time:    5:30 PM
 */
public class LongestPalidromicSubstring {

  public int startIndex,maxLen;

  public static void main(String[] args) {
    String inp = "cbbd";
    //System.out.println(longestPalindromeOne(inp));
    LongestPalidromicSubstring lps = new LongestPalidromicSubstring();
    System.out.println(lps.longestPalindrome(inp));

  }

  public static String longestPalindromeOne(String s) {

    if (s.length() < 2) return s;

    String maxPalindrome = "";

    for (int i = 0; i < s.length(); i++) {
     String curr =  extendPalindrome(s,i,i);
     if (curr.length() > maxPalindrome.length()) {
       maxPalindrome = curr;
     }
    }
    return maxPalindrome;
  }

  private static String extendPalindrome(String s , int low, int high) {
    while (low >=0 && high < s.length()) {

      if (s.charAt(low) == s.charAt(high)) {
        low--;
        high++;
      } else {
        break;
      }
    }
    return s.substring(low+1, high);
  }

  public String longestPalindrome(String s) {
    if (s.length() < 2 ) return s;

    for(int i = 0; i< s.length(); i++) {
      expandPalindrome(s, i , i);
      expandPalindrome(s, i, i+1);
    }

    return s.substring(startIndex, startIndex+ maxLen);
  }

  public void expandPalindrome(String s , int l, int h) {
    while( l >=0 && h < s.length() &&
        s.charAt(l) == s.charAt(h)) {
      l--;
      h++;
    }

    if ( maxLen < h-l-1) {
      maxLen = h-l-1;
      startIndex = l+1;
    }
  }
}
