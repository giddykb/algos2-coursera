package dcp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/12/18
 * Time:    10:33 PM
 *
 * Let 1 represent ‘A’, 2 represents ‘B’, etc.
 * Given a digit sequence, count the number of possible decodings of the given digit sequence.
 *

 *
 */
public class DecodingDigit {

  public static void main(String[] args) {

    int digits [] = {1,2,2,3};
    System.out.println(countDecode(digits));

  }


  static int countDecode(int digits[])  {

    int n = digits.length;
    int count []  = new int [n+1];
    count[0] = 1;
    count[1] = 1;
    for (int i = 2; i <=n ; i++) {
      count[i] = 0;

      if (digits[i-1] != 0) {
        count[i] = count[i-1];
      }

      if( (digits[i-2] == 1 || digits[i-2] == 2)
          && digits[i-1] < 7) {
        count[i] += count[i-2];
      }

    }

    return count[n];

  }


}
