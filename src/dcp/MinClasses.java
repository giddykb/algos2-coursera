package dcp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    29/12/18
 * Time:    4:27 PM
 *
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class MinClasses {

  public static void main(String[] args) {
    int start[] = {30,0,60};
    int end [] = {75,50,150};
    System.out.println(minRequired(start, end));
  }

  static int minRequired( int[] start, int [] end) {

    Arrays.sort(end);
    Arrays.sort(start);

    int i = 0 ;
    int j = 0 ;

    int maxRoomsRequired = 0;
    int roomsNeeded = 0 ;
    int totalLectures = start.length;

    while (i < totalLectures && j < totalLectures) {
      if (start[i] < end[j]) {
        roomsNeeded++;
        i++;
        if (roomsNeeded > maxRoomsRequired) {
          maxRoomsRequired = roomsNeeded;
        }
      }
      else {
        roomsNeeded--;
        j++;
      }
    }
    return maxRoomsRequired;
  }
}
