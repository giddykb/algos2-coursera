package amazon;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/04/19
 * Time:    3:26 PM
 *
 * Given an array, return the list of first negative integer of every subarray of size k.
 *
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 *
 */
public class FirstNegativeInWindow {

  public static void main(String[] args) {

    int arr[] = {12, -1, -7, 8, -15, 30, 16, 28} ;
    int k = 3 ;

    printFirstNegative(arr, k);
  }

  static void printFirstNegative(int nums[] , int k) {

    for (int i = 0; i < nums.length-k+1 ; i++) {
      boolean isNegative = false;
      for (int j = 0; j <k ; j++) {
        if (nums[i+j] < 0) {
          isNegative = true;
          System.out.print( nums[i+j] + " ");
          break;
        }
      }
      if (!isNegative) {
        System.out.print( " "  + 0  + " ");
      }
    }
  }
}
