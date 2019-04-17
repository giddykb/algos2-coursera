package com.peace.strings;


import java.util.HashSet;

/*
*
* https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
*
* */
class LongestSubStringAtLeastK {

  public static void main(String[] args) {
    String s = "bbaaacbd";
    int k = 3;
    System.out.println(longestSubstring(s,k));
  }
  public static int longestSubstring(String s, int k) {
      if (s == null || s.length() == 0 ) return 0;
        int freq [] = new int[26];
        
        boolean atLeastKLengthString = true;
        
        for(int i = 0; i<s.length(); i++) {
            freq[s.charAt(i)- 'a']++;
        }
        
        for (int i =0; i < freq.length;i++) {
            if (freq[i] < k && freq[i] > 0) atLeastKLengthString = false;
        }
        
        if(atLeastKLengthString) return  s.length();
        
        int startIndex = 0; 
        int endIndex = 0 ; 
        int rightIndex = 0 ;
        int leftIndex = 0; 
        int maxLength = 0 ;
        
        while (rightIndex < s.length()) {
            if (freq[s.charAt(rightIndex)- 'a'] < k ) {
                int  currLength = longestSubstring(s.substring(leftIndex, rightIndex),k);
                if (currLength > maxLength) {
                    maxLength = currLength;
                    startIndex = leftIndex;
                    endIndex = rightIndex;
                }
              leftIndex = rightIndex+1;;
            }
            rightIndex++;
        }

    int  currLength = longestSubstring(s.substring(leftIndex),k);
    if (rightIndex - leftIndex > endIndex - startIndex) {
      maxLength = currLength;
      startIndex = leftIndex;
      endIndex = rightIndex;
    }
    //maxLength = Math.max(maxLength, longestSubstring(s.substring(leftIndex), k));
    System.out.println(s.substring(startIndex,endIndex));
    return maxLength;
    }



}