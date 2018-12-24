package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/11/18
 * Time:    8:53 PM
 *
 *
 *
 * Given a number of boxes with different colors represented by different positive numbers.
 * You need to remove all the boxes in several rounds, each time you can choose continuous boxes
 * with the same color (means with same numbers, composed of k boxes, k >= 1),
 * remove them and get k*k points. Write an algorithm to get the maximum points by removing all the boxes.

 Reference: https://leetcode.com/problems/remove-boxes/description/

 Example : 1233211

 Remove 33 – Profit = 2*2 = 4, Remaining = 12211
 Remove 22 – Profit = 4 + 2*2 = 8, Remaining = 111
 Remove 11 - Profit = 3*3 + 8 = 17
 */
public class RemoveBoxes {

  public static void main(String[] args) {

  }

  public static int removeBoxes(String input) {

    if (input == null || input.length() == 0) return 0;
    if(input.length() == 1) return 1;

    int profit = 0;
    int startIndex = 0;
    int endIndex = 0;
    while (startIndex < input.length()) {
      char c = input.charAt(startIndex);
      int count = 0;
      while (endIndex < input.length() && c == input.charAt(endIndex)) {
        endIndex++;
        count++;
      }
    }
    return profit;
  }



}
