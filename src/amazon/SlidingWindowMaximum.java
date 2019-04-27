package amazon;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/04/19
 * Time:    6:44 PM
 */
public class SlidingWindowMaximum {
  public static void main(String[] args) {
    int [] nums = {1, 2, 3, 2, 4, 1, 5, 6, 1};
    int k = 3;
    maximumInWindow(nums, k);
  }

  static void maximumInWindow( int arr[], int k) {
    if(arr == null || k <= 0) {
      //return new int[0];
    }

    int n = arr.length;

    for (int i = 0; i < n-k+1 ; i++) {
      int max = arr[i];
      for (int j = 1; j < k ; j++) {
        if(arr[i+j] > max) {
          max = arr[i+j];
        }
      }
      System.out.print(max + " " );
    }

  }
}
