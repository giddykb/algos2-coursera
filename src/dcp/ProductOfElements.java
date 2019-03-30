package dcp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    01/12/18
 * Time:    9:24 PM
 */
public class ProductOfElements {

  public static void main(String[] args) {

    int a[] = {1,2,3,4,5};
    int res [] = solution(a);
    System.out.println(Arrays.toString(res));

  }


  private static int [] solution(int a[]) {
    int result [] = new int [a.length];
    int frontCache [] = new int [a.length];
    int backCache [] = new int [a.length];
    int lastKey = a.length -1;
    frontCache[0] = 1;
    backCache[lastKey] = 1 ;

    int frontTotal = 1;
    int backTotal = 1;

    for (int i = 0; i < lastKey ; i++) {
      if(i != lastKey) {
        frontTotal = frontTotal * a[i];
        frontCache[i+1] = frontTotal;
        int reverseKey = lastKey-i;
        backTotal = backTotal * a[reverseKey];
        backCache[reverseKey-1] = backTotal;
      }
    }

    for (int i = 0; i <= lastKey ; i++) {
      result[i] = frontCache[i] * backCache[i];
    }
    return result;

  }


}
