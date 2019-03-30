package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/03/19
 * Time:    10:27 PM
 */
public class LongestCommonSubString {

  public static void main(String[] args) {

    String s = "ABABC";
    String t = "BABCA";
    LongestCommonSubString lcs = new LongestCommonSubString();
    System.out.println(lcs.longestCommonSubString(s,t));

  }

  public String longestCommonSubString(String s , String t) {

    int LCS [][] = new int[s.length()+1] [t.length()+1 ];
    int maxLen  = 0;
    int endIndex = 0;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <=t.length() ; j++) {
        if (s.charAt(i-1) == t.charAt(j-1)) {
          LCS[i][j] = 1+ LCS[i-1][j-1];
          if ( LCS[i][j] > maxLen) {
            maxLen = LCS[i][j];
            endIndex = j;
          }
        }
      }
    }
    return t.substring(maxLen - endIndex, endIndex);
  }


}
